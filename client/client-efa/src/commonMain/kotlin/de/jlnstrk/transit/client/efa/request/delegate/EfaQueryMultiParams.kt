package de.jlnstrk.transit.client.efa.request.delegate

import de.jlnstrk.transit.client.efa.request.convert.deserializeAsT
import de.jlnstrk.transit.client.efa.request.convert.serializeT
import kotlin.reflect.KClass

internal object EfaStringMultiParam : EfaQueryMultiParam<String>({ it }, { it })

internal class EfaEnumMultiParam<E : Enum<E>>(type: KClass<E>, key: String? = null) :
    EfaQueryMultiParam<E>({ it.serializeT(type) }, { it.deserializeAsT(type) }, key) {
    companion object {
        internal inline operator fun <reified E : Enum<E>> invoke(key: String? = null): EfaEnumMultiParam<E> {
            return EfaEnumMultiParam(E::class, key)
        }
    }
}