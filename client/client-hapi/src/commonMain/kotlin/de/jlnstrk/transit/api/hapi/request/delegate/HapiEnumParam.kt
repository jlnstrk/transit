package de.jlnstrk.transit.api.hapi.request.delegate

import kotlin.reflect.KClass

internal open class HapiEnumParam<E : Enum<E>>(type: KClass<E>) :
    HapiQueryParam<E>({ it.serializeT(type) }, { it.deserializeAsT(type) }) {
    companion object {
        inline operator fun <reified E : Enum<E>> invoke(): HapiEnumParam<E> {
            return HapiEnumParam(E::class)
        }
    }

    internal class List<E : Enum<E>>(type: KClass<E>) : HapiQueryParam<kotlin.collections.List<E>>(
        serialize = { it.joinToString(",") { it.serializeT(type) } },
        deserialize = { it.split(",").map { it.deserializeAsT(type) } }
    ) {
        companion object {
            inline operator fun <reified E : Enum<E>> invoke(): List<E> {
                return List(E::class)
            }
        }
    }

    internal class Set<E : Enum<E>>(type: KClass<E>) : HapiQueryParam<kotlin.collections.Set<E>>(
        serialize = { it.joinToString(",") { it.serializeT(type) } },
        deserialize = { it.split(",").map { it.deserializeAsT(type) }.toSet() }
    ) {
        companion object {
            inline operator fun <reified E : Enum<E>> invoke(): Set<E> {
                return Set(E::class)
            }
        }
    }
}