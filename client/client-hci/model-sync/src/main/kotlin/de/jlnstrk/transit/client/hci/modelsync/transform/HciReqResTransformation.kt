@file:OptIn(ExperimentalStdlibApi::class)

package de.jlnstrk.transit.client.hci.modelsync.transform

import com.squareup.kotlinpoet.*
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_HCI_SERVICE_METHOD
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_HCI_SERVICE_REQUEST
import de.jlnstrk.transit.client.hci.modelsync.TYPE_NAME_HCI_SERVICE_RESULT

fun TypeSpec.asServiceRequest(): TypeSpec {
    val methodName = name!!.substringAfter("HCIServiceRequest_")
    val typeName = ClassName("", "Hci${methodName}ServiceRequestType")
    return TypeSpec.classBuilder(typeName)
        .addModifiers(KModifier.DATA)
        .addSuperinterface(TYPE_NAME_HCI_SERVICE_REQUEST)
        .primaryConstructor(primaryConstructor)
        .addProperties(propertySpecs.map {
            it.toBuilder()
                .mutable(true)
                .build()
        })
        .addProperty(
            PropertySpec.builder("method", TYPE_NAME_HCI_SERVICE_METHOD, KModifier.OVERRIDE)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode("HciServiceMethod.$methodName")
                        .build()
                )
                .build()
        )

        // DSL companion
        .addType(
            TypeSpec.companionObjectBuilder()
                .addFunction(
                    FunSpec.builder("invoke")
                        .addModifiers(KModifier.INLINE, KModifier.OPERATOR)
                        .addParameter("init", LambdaTypeName.get(typeName, returnType = typeNameOf<Unit>()))
                        .addCode("%L().apply(%L)", typeName, "init")
                        .build()
                )
                .build()
        )
        .build()
}

fun TypeSpec.asServiceResult(): TypeSpec {
    val methodName = name!!.substringAfter("HCIServiceResult_")
    val typeName = ClassName("", "Hci${methodName}Result")
    return TypeSpec.classBuilder(typeName)
        .primaryConstructor(primaryConstructor)
        .addProperties(propertySpecs)
        .superclass(TYPE_NAME_HCI_SERVICE_RESULT)
        .build()
}