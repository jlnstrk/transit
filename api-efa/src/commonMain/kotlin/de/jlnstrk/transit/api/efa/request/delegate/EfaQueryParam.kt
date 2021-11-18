package de.jlnstrk.transit.api.efa.request.delegate

import de.jlnstrk.transit.api.efa.request.EfaRequestMapDelegate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal open class EfaQueryParam<T>(
    internal val serialize: (T) -> String,
    internal val deserialize: (String) -> T?,
    private val key: String? = null,
) : ReadWriteProperty<EfaRequestMapDelegate, T?> {

    fun withKey(key: String): EfaQueryParam<T> = EfaQueryParam(serialize, deserialize, key)

    override fun getValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>): T? {
        return thisRef.queryMap[key]?.let(deserialize)
    }

    override fun setValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>, value: T?) {
        if (value != null) {
            thisRef.queryMap[key ?: property.name] = serialize(value)
        } else {
            thisRef.queryMap.remove(key ?: property.name)
        }
    }
}