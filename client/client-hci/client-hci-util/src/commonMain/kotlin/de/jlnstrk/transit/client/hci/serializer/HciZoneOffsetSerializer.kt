package de.jlnstrk.transit.client.hci.serializer

import kotlinx.datetime.FixedOffsetTimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object HciZoneOffsetSerializer : KSerializer<FixedOffsetTimeZone> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ZoneOffset", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: FixedOffsetTimeZone) {
        encoder.encodeInt(value.offset.totalSeconds / 60)
    }

    override fun deserialize(decoder: Decoder): FixedOffsetTimeZone {
        val value = decoder.decodeInt()
        val hours = value / 60
        val minutes = value % 60
        return FixedOffsetTimeZone(UtcOffset(hours, minutes))
    }
}