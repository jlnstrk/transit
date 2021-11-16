package de.jlnstrk.transit.api.efa.request.delegate

import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal open class EfaQueryMultiParam<T>(
    internal val serialize: (T) -> String,
    internal val deserialize: (String) -> T?,
    private val key: String? = null,
) : ReadWriteProperty<EfaRequestMapDelegate, Set<T>> {

    fun withKey(key: String): EfaQueryMultiParam<T> = EfaQueryMultiParam(serialize, deserialize, key)

    override fun getValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>): Set<T> {
        return thisRef.queryMap.getAll(key ?: property.name)
            .mapNotNull(deserialize)
            .toSet()
    }

    override fun setValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>, value: Set<T>) {
        thisRef.queryMap.putAll(key ?: property.name, value.map(serialize).toSet())
    }
}