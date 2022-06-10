package de.jlnstrk.transit.client.hapi.serializer

import kotlinx.datetime.UtcOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HapiZoneOffsetSerializer : KSerializer<UtcOffset> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ZoneOffset", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: UtcOffset) {
        encoder.encodeInt(value.totalSeconds / 60)
    }

    override fun deserialize(decoder: Decoder): UtcOffset {
        return UtcOffset(minutes = decoder.decodeInt())
    }
}