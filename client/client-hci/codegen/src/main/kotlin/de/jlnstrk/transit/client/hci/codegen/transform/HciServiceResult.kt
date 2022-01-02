package de.jlnstrk.transit.client.hci.codegen.transform

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import de.jlnstrk.transit.client.hci.codegen.TypeNames

fun TypeSpec.transformAbstractHciServiceResult(): TypeSpec {
    return toBuilder().apply {
        modifiers.remove(KModifier.DATA)
        addModifiers(KModifier.ABSTRACT)
    }.build()
}

fun TypeSpec.transformConcreteHciServiceResult(): TypeSpec {
    val methodName = name!!.substringAfter("HciServiceResult_")
    val typeName = TypeNames.HciServiceResult(methodName)
    return TypeSpec.classBuilder(typeName).apply {
        primaryConstructor(this@transformConcreteHciServiceResult.primaryConstructor)
        addProperties(this@transformConcreteHciServiceResult.propertySpecs)
        superclass(TypeNames.HciServiceResult)
    }.build()
}