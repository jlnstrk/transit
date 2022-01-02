package de.jlnstrk.transit.client.hci.codegen.generate

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jlnstrk.transit.client.hci.codegen.DISABLED_SERVICE_METHODS
import de.jlnstrk.transit.client.hci.codegen.TypeNames
import de.jlnstrk.transit.client.hci.codegen.transform.extractSerialName
import kotlin.reflect.KClass

fun buildMethodToResultTypeMap(methodSpec: FileSpec, destinationPackage: String): FileSpec {
    val methodType = methodSpec.members[0] as TypeSpec
    val methodTypeName = ClassName(methodSpec.packageName, methodType.name!!)
    return FileSpec.builder(destinationPackage, "HciServiceMethod").apply {
        addProperty(PropertySpec.builder(
            "resultType",
            KClass::class.asTypeName()
                .parameterizedBy(WildcardTypeName.producerOf(TypeNames.HciServiceResult))
        ).apply {
            receiver(TypeNames.HciServiceMethod)
            getter(FunSpec.getterBuilder().apply {
                beginControlFlow("return when (this)")
                for ((name, spec) in methodType.enumConstants) {
                    val methodSerialName = spec.extractSerialName()
                    if (methodSerialName in DISABLED_SERVICE_METHODS) {
                        addStatement(
                            "%T.$name -> throw %T()",
                            TypeNames.HciServiceMethod,
                            TypeNames.UnsupportedOperationException
                        )
                    } else {
                        addStatement(
                            "%T.$name -> %T::class",
                            TypeNames.HciServiceMethod,
                            TypeNames.HciServiceResult(methodSerialName)
                        )
                    }
                }
                endControlFlow()
            }.build())
        }.build()
        )
    }.build()
}