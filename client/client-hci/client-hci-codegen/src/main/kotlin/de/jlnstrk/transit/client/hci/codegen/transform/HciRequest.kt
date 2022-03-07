package de.jlnstrk.transit.client.hci.codegen.transform

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.codegen.TypeNames

fun TypeSpec.transformHciRequest(): TypeSpec {
    fun ParameterizedTypeName.transform(): TypeName {
        return rawType.parameterizedBy(
            typeArguments[0]
                .copy(annotations = listOf(
                    AnnotationSpec.builder(TypeNames.Serializable)
                        .addMember("with = %T::class", TypeNames.HciServiceRequestFrameSerializer)
                        .build()
                )
                )
        )
    }

    return toBuilder().apply {
        propertySpecs.replaceAll {
            if (it.name == "svcReqL") {
                it.toBuilder(type = (it.type as ParameterizedTypeName).transform()).build()
            } else it
        }
        primaryConstructor?.let {
            primaryConstructor(it.toBuilder().apply {
                parameters.replaceAll {
                    if (it.name == "svcReqL") {
                        it.toBuilder(type = (it.type as ParameterizedTypeName).transform()).build()
                    } else it
                }
            }.build())
        }
    }.build()
}