@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.codegen.transform

import com.squareup.kotlinpoet.*
import de.jlnstrk.transit.client.hci.codegen.TypeNames

fun TypeSpec.transformAbstractHciServiceRequest(): TypeSpec {
    return toBuilder().apply {
        modifiers.remove(KModifier.DATA)
        addModifiers(KModifier.ABSTRACT)
    }.build()
}

fun TypeSpec.transformConcreteHciServiceRequest(): TypeSpec {
    val methodName = name!!.substringAfter("HciServiceRequest_")
    val typeName = TypeNames.HciServiceRequest(methodName)
    return TypeSpec.classBuilder(typeName).apply {
        addModifiers(KModifier.DATA)
        superclass(TypeNames.HciServiceRequest)
        primaryConstructor(this@transformConcreteHciServiceRequest.primaryConstructor!!.toBuilder().apply {
            parameters.replaceAll { paramSpec ->
                if (paramSpec.type is ParameterizedTypeName) {
                    paramSpec
                } else {
                    paramSpec.toBuilder(type = paramSpec.type.copy(nullable = true))
                        .defaultValue("null")
                        .build()
                }
            }
        }.build())
        addProperties(this@transformConcreteHciServiceRequest.propertySpecs.map { propSpec ->
            val type = if (propSpec.type !is ParameterizedTypeName) {
                propSpec.type.copy(nullable = true)
            } else propSpec.type
            propSpec.toBuilder(type = type)
                .mutable(true)
                .build()
        })

        // DSL companion
        addType(
            TypeSpec.companionObjectBuilder()
                .addFunction(
                    FunSpec.builder("invoke")
                        .addModifiers(KModifier.INLINE, KModifier.OPERATOR)
                        .addParameter("init", LambdaTypeName.get(typeName, returnType = typeNameOf<Unit>()))
                        .returns(typeName)
                        .addCode("return %L().apply(%L)", typeName, "init")
                        .build()
                )
                .build()
        )
    }.build()
}
