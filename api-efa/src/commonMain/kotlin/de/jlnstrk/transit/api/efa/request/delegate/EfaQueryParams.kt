package de.jlnstrk.transit.api.efa.request.delegate

import de.jlnstrk.transit.api.efa.request.convert.deserializeAsT
import de.jlnstrk.transit.api.efa.request.convert.serializeT
import kotlin.reflect.KClass

internal object EfaStringParam : EfaQueryParam<String>({ it }, { it })

internal object EfaIntParam : EfaQueryParam<Int>(kotlin.Int::toString, kotlin.String::toInt)

internal object EfaBooleanParam : EfaQueryParam<Boolean>({ if (it) "1" else "0" }, { it == "1" })

internal class EfaEnumParam<E : Enum<E>>(type: KClass<E>, key: String? = null) :
    EfaQueryParam<E>({ it.serializeT(type) }, { it.deserializeAsT(type) }, key) {
    companion object {
        inline operator fun <reified E : kotlin.Enum<E>> invoke(key: String? = null): EfaEnumParam<E> {
            return EfaEnumParam(E::class, key)
        }
    }
}