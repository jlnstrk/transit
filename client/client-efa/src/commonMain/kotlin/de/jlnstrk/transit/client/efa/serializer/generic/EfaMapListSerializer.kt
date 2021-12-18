package de.jlnstrk.transit.client.efa.serializer.generic

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

internal class EfaMapListSerializer<K, V>(
    private val keySerializer: KSerializer<K>,
    private val valueSerializer: KSerializer<V>
) : KSerializer<Map<K, V>> {
    private val listSerializer = ListSerializer(Pair.serializer())
    override val descriptor: SerialDescriptor = listSerializer.descriptor

    @Serializable
    internal data class Pair(
        private val name: String? = null,
        private val ticket: String? = null,
        val value: String
    ) {
        val key: String get() = name ?: ticket!!
    }

    override fun serialize(encoder: Encoder, value: Map<K, V>) {
        val list = value.entries.map { (key, value) ->
            Pair(
                Json.encodeToJsonElement(keySerializer, key).jsonPrimitive.content,
                null,
                Json.encodeToJsonElement(valueSerializer, value).jsonPrimitive.content
            )
        }
        listSerializer.serialize(encoder, list)
    }

    override fun deserialize(decoder: Decoder): Map<K, V> {
        val list = listSerializer.deserialize(decoder)
        val map = mutableMapOf<K, V>()
        for (pair in list) {
            val key = Json.decodeFromJsonElement(keySerializer, JsonPrimitive(pair.key))
            val value = Json.decodeFromJsonElement(valueSerializer, JsonPrimitive(pair.value))
            map[key] = value
        }
        return map
    }
}