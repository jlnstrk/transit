@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen.transform

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.PrimitiveType
import com.github.javaparser.ast.type.Type
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jlnstrk.transit.client.hci.codegen.*

val PATTERN_LOCAL_DATE = Regex("[a-zA-Z_]+Date(?:[A-Z]+[a-zA-Z_]*)?|date(?:[A-Z]+[a-zA-Z_]*)?")
val PATTERN_LOCAL_TIME = Regex("[a-zA-Z_]+Time(?:[A-Z]+[a-zA-Z_]*)?|time(?:[A-Z]+[a-zA-Z_]*)?")
val PATTERN_ZONE_OFFSET = Regex("[a-zA-Z_]+TZOffset(?:[A-Z]+[a-zA-Z_]*)?|TZOffset(?:[A-Z]+[a-zA-Z_]*)?")
val PATTERN_PROP_NAME_OBFUSCATION = Regex("f[0-9]{4}([a-z]+)")

fun ClassOrInterfaceDeclaration.transformDataClass(): TypeSpec? {
    val className = name.toString()
    val classSpec = TypeSpec.classBuilder(className)
    val primaryConstructor = FunSpec.constructorBuilder()

    if (className.startsWith("HCIService_")) {
        return null
    }

    val nullableGetters = methods.filter {
        it.nameAsString.startsWith("get")
                && it.annotations.any { it.name.asString() == "Nullable" }
    }.map {
        it.nameAsString.substring(3)
            .lowercase()
    }.toSet()

    fields.forEach { fieldDecl ->
        val variable = fieldDecl.getVariable(0)
        var variableName = variable.name.asString()
        var variableType = fieldDecl.elementType.resolveKotlinType()

        PATTERN_PROP_NAME_OBFUSCATION.matchEntire(variableName)?.let { match ->
            variableName = match.groupValues[1]
        }

        if (variableType !is ParameterizedTypeName) {
            if (variableName.lowercase() in nullableGetters
                && !variableType.isNullable
            ) {
                variableType = variableType.copy(nullable = true)
            }
            when {
                variableType.toString().startsWith("kotlin.String") -> when {
                    variableName.matches(PATTERN_LOCAL_DATE) -> variableType = TypeNames.dateType
                        .copy(nullable = variableType.isNullable)
                    variableName.matches(PATTERN_LOCAL_TIME) -> variableType = TypeNames.timeType
                        .copy(nullable = variableType.isNullable)
                }
                variableType.toString().startsWith("kotlin.Int") -> when {
                    variableName.matches(PATTERN_ZONE_OFFSET) -> variableType = TypeNames.zoneOffsetType
                        .copy(nullable = variableType.isNullable)
                }
            }
        }

        val paramSpec = ParameterSpec.builder(variableName, variableType)
        if (variableType is ParameterizedTypeName) {
            when (variableType.rawType.simpleName) {
                "Map" -> paramSpec.defaultValue("emptyMap()")
                "Set" -> paramSpec.defaultValue("emptySet()")
                "List" -> paramSpec.defaultValue("emptyList()")
            }
        } else {
            if (variableType.isNullable) {
                paramSpec.defaultValue("null")
            } else {
                val type = fieldDecl.elementType
                val initializer = fieldDecl.variables[0].initializer.orElse(null)
                when {
                    type is PrimitiveType
                            || (type is ClassOrInterfaceType && type.isBoxedType) -> {
                        fieldDecl.annotations
                            .firstOrNull { it.nameAsString == "a" }
                            ?.let { annotation ->
                                paramSpec.defaultValue(
                                    (annotation as SingleMemberAnnotationExpr)
                                        .memberValue.toString()
                                        .drop(1)
                                        .dropLast(1)
                                )
                            }
                    }
                    initializer != null -> {
                        // We're assuming this is an enum
                        paramSpec.defaultValue(
                            "%T.${initializer.toString().substringAfter('.')}",
                            type.resolveKotlinType()
                        )
                    }
                }
            }
        }

        primaryConstructor.addParameter(paramSpec.build())
        val propertySpec = PropertySpec.builder(variableName, variableType)
            .initializer(variableName)

        CustomSerializers[variableType.copy(nullable = false)]?.let { serializerType ->
            propertySpec.addAnnotation(
                AnnotationSpec.builder(TypeNames.Serializable)
                    .addMember("with = %T::class", serializerType)
                    .build()
            )
        }

        classSpec.addProperty(propertySpec.build())
    }
    return classSpec
        .addModifiers(KModifier.DATA)
        .primaryConstructor(primaryConstructor.build())
        .build()
}

fun Type.resolveKotlinType(): TypeName = when (this) {
    is ClassOrInterfaceType -> when {
        asString().startsWith("HCI") -> ClassName(
            asString().destinationPackageName(),
            "Hci" + asString().substring(3)
        )
        isBoxedType -> toUnboxedType().resolveKotlinType()
        nameAsString == "List" -> List::class.asTypeName()
            .parameterizedBy(typeArguments.get().first.get().resolveKotlinType())
        nameAsString == "Set" -> List::class.asTypeName()
            .parameterizedBy(typeArguments.get().first.get().resolveKotlinType())
        nameAsString == "Map" -> Map::class.asTypeName().parameterizedBy(
            typeArguments.get()[0].resolveKotlinType(),
            typeArguments.get()[1].resolveKotlinType()
        )
        nameAsString == "String" -> typeNameOf<String>()
        else -> throw IllegalArgumentException(asString())
    }
    is PrimitiveType -> when (type!!) {
        PrimitiveType.Primitive.BOOLEAN -> typeNameOf<Boolean>()
        PrimitiveType.Primitive.CHAR -> typeNameOf<Char>()
        PrimitiveType.Primitive.BYTE -> typeNameOf<Byte>()
        PrimitiveType.Primitive.SHORT -> typeNameOf<Short>()
        PrimitiveType.Primitive.INT -> typeNameOf<Int>()
        PrimitiveType.Primitive.LONG -> typeNameOf<Long>()
        PrimitiveType.Primitive.FLOAT -> typeNameOf<Float>()
        PrimitiveType.Primitive.DOUBLE -> typeNameOf<Double>()
    }
    else -> throw IllegalArgumentException()
}