package de.jlnstrk.transit.api.efa.serializer.generic

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive

internal class EfaEnumMaskSerializer<E : Enum<E>>(
    private val elementSerializer: KSerializer<E>
) : KSerializer<Set<E>> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(EfaEnumMaskSerializer::class.simpleName!!, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Set<E>) {
        val string = value.joinToString(separator = "|") {
            Json.encodeToJsonElement(elementSerializer, it).jsonPrimitive.content
        }
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): Set<E> {
        return decoder.decodeString()
            .split("|")
            .map { Json.decodeFromJsonElement(elementSerializer, JsonPrimitive(it)) }
            .toSet()
    }
}