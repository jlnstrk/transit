package de.jlnstrk.transit.client.hci.codegen.generate

import com.squareup.kotlinpoet.*
import de.jlnstrk.transit.client.hci.codegen.DISABLED_SERVICE_METHODS
import de.jlnstrk.transit.client.hci.codegen.TypeNames
import de.jlnstrk.transit.client.hci.codegen.transform.extractSerialName

fun buildRequestTypeToMethodMap(methodSpec: FileSpec, destinationPackage: String): FileSpec {
    val methodType = methodSpec.members[0] as TypeSpec
    return FileSpec.builder(destinationPackage, "HciServiceRequest").apply {
        addProperty(
            PropertySpec.builder(
                "method", TypeNames.HciServiceMethod
            ).apply {
                receiver(TypeNames.HciServiceRequest)
                getter(FunSpec.getterBuilder().apply {
                    beginControlFlow("return when (this::class)")
                    for ((name, spec) in methodType.enumConstants) {
                        val methodSerialName = spec.extractSerialName()
                        if (methodSerialName in DISABLED_SERVICE_METHODS) {
                            continue
                        }
                        addStatement(
                            "%T::class -> %T.$name",
                            TypeNames.HciServiceRequest(methodSerialName),
                            TypeNames.HciServiceMethod
                        )
                    }
                    addStatement("else -> throw %T()", TypeNames.IllegalArgumentException)
                    endControlFlow()
                }.build())
            }.build()
        )
    }.build()
}