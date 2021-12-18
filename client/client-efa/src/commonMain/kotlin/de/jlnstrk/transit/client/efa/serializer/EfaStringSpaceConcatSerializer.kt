package de.jlnstrk.transit.client.efa.serializer

import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

internal class EfaStringSpaceConcatSerializer<T>(
    unused: KSerializer<T>? = null
) : KSerializer<List<EfaCoordinates>> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("EfaStringSpaceConcat", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: List<EfaCoordinates>) {
        val delegate = (encoder as JsonEncoder).serializersModule
            .getContextual(EfaCoordinates::class)!!
        val string = value.joinToString(separator = " ") {
            Json.encodeToJsonElement(delegate, it).jsonPrimitive.content
        }
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): List<EfaCoordinates> {
        val delegate = (decoder as JsonDecoder).serializersModule
            .getContextual(EfaCoordinates::class)!!
        return decoder.decodeString()
            .split(' ')
            .map { Json.decodeFromJsonElement(delegate, JsonPrimitive(it)) }
    }
}