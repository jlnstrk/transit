package de.jlnstrk.transit.client.efa.request.delegate

import de.jlnstrk.transit.client.efa.request.EfaRequestMapDelegate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal open class EfaQueryFlag(
    private val key: String? = null
) : ReadWriteProperty<EfaRequestMapDelegate, Boolean?> {

    override fun getValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>): Boolean {
        return thisRef.queryMap.containsKey(key ?: property.name)
    }

    override fun setValue(thisRef: EfaRequestMapDelegate, property: KProperty<*>, value: Boolean?) {
        if (value == true) {
            thisRef.queryMap[key ?: property.name] = "1"
        } else {
            thisRef.queryMap.remove(key ?: property.name)
        }
    }

    internal companion object : EfaQueryFlag()
}