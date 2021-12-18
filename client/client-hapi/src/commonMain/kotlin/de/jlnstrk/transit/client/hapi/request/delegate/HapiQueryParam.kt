package de.jlnstrk.transit.client.hapi.request.delegate

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

public inline fun <reified T : Enum<T>> T.serialize(): String =
    Json.encodeToJsonElement(serializer(), this).jsonPrimitive.content

public inline fun <reified T : Enum<T>> String.deserializeAs(): T =
    Json.decodeFromJsonElement(serializer(), JsonPrimitive(this))

@OptIn(InternalSerializationApi::class)
public inline fun <T : Enum<T>> T.serializeT(type: KClass<T>): String =
    Json.encodeToJsonElement(type.serializer(), this).jsonPrimitive.content

@OptIn(InternalSerializationApi::class)
public inline fun <T : Enum<T>> String.deserializeAsT(type: KClass<T>): T =
    Json.decodeFromJsonElement(type.serializer(), JsonPrimitive(this))

internal open class HapiQueryParam<T>(
    private val serialize: (T) -> String,
    private val deserialize: (String) -> T?
) : ReadWriteProperty<MutableMap<String, String>, T?> {
    override fun getValue(thisRef: MutableMap<String, String>, property: KProperty<*>): T? {
        return thisRef[property.name]?.let(deserialize)
    }

    override fun setValue(thisRef: MutableMap<String, String>, property: KProperty<*>, value: T?) {
        if (value != null) {
            thisRef[property.name] = serialize(value)
        } else {
            thisRef.remove(property.name)
        }
    }

}