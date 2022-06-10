package de.jlnstrk.transit.common

import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import kotlin.reflect.KClass

public fun Provider.require(serviceProtocol: ObjCProtocol): Service {
    val serviceClass = getOriginalKotlinClass(serviceProtocol)
    return require(serviceClass as KClass<Service>)
}

public fun Provider.optional(serviceProtocol: ObjCProtocol): Service? {
    val serviceClass = getOriginalKotlinClass(serviceProtocol)
    return optional(serviceClass as KClass<Service>)
}