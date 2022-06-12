package de.jlnstrk.transit.client.hci.serializer

import kotlinx.datetime.UtcOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object HciUtcOffsetSerializer : KSerializer<UtcOffset> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("UtcOffset", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: UtcOffset) {
        encoder.encodeInt(value.totalSeconds / 60)
    }

    override fun deserialize(decoder: Decoder): UtcOffset {
        val value = decoder.decodeInt()
        val hours = value / 60
        val minutes = value % 60
        return UtcOffset(hours, minutes)
    }
}