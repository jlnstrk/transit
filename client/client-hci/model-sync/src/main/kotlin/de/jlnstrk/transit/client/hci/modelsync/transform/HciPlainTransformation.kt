@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.modelsync.transform

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.PrimitiveType
import com.github.javaparser.ast.type.Type
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_UTIL_LOCAL_DATE
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_UTIL_LOCAL_TIME
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_UTIL_ZONE_OFFSET

val PATTERN_LOCAL_DATE = Regex("[a-zA-Z_]+Date(?:[A-Z]+[a-zA-Z_]*)?|date(?:[A-Z]+[a-zA-Z_]*)?")
val PATTERN_LOCAL_TIME = Regex("[a-zA-Z_]+Time(?:[A-Z]+[a-zA-Z_]*)?|time(?:[A-Z]+[a-zA-Z_]*)?")
val PATTERN_ZONE_OFFSET = Regex("[a-zA-Z_]+ZTOffset(?:[A-Z]+[a-zA-Z_]*)?|TZOffset(?:[A-Z]+[a-zA-Z_]*)?")

fun ClassOrInterfaceDeclaration.toPlainRepresentation(): TypeSpec {
    val className = name.toString()
    val classSpec = TypeSpec.classBuilder(className)
    val primaryConstructor = FunSpec.constructorBuilder()

    val nullableGetters = methods.filter {
        it.nameAsString.startsWith("get")
                && it.annotations.any { it.name.asString() == "Nullable" }
    }.map {
        it.nameAsString.substring(3)
            .replaceFirstChar(Char::toLowerCase)
    }.toSet()

    fields.forEach { fieldDecl ->
        val variable = fieldDecl.getVariable(0)
        val variableName = variable.name.asString()
        var variableType = fieldDecl.elementType.resolveKotlinType()

        if (variableType !is ParameterizedTypeName) {
            if (variableName in nullableGetters
                && !variableType.isNullable) {
                variableType = variableType.copy(nullable = true)
            }
            if (variableType.toString().startsWith("kotlin.String")) {
                when {
                    variableName.matches(PATTERN_LOCAL_DATE) -> variableType = TYPE_NAME_UTIL_LOCAL_DATE
                        .copy(nullable = variableType.isNullable)
                    variableName.matches(PATTERN_LOCAL_TIME) -> variableType = TYPE_NAME_UTIL_LOCAL_TIME
                        .copy(nullable = variableType.isNullable)
                    variableName.matches(PATTERN_ZONE_OFFSET) -> variableType = TYPE_NAME_UTIL_ZONE_OFFSET
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
            }
        }

        primaryConstructor.addParameter(paramSpec.build())
        val propertySpec = PropertySpec.builder(variableName, variableType)
            .initializer(variableName)
        classSpec.addProperty(propertySpec.build())
    }
    return classSpec
        .addModifiers(KModifier.DATA)
        .primaryConstructor(primaryConstructor.build())
        .build()
}

fun Type.resolveKotlinType(): TypeName = when (this) {
    is ClassOrInterfaceType -> when {
        asString().startsWith("HCI") -> ClassName("", "Hci" + asString().substring(3))
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