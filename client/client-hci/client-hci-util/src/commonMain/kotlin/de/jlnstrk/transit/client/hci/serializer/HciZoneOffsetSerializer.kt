package de.jlnstrk.transit.client.hci.serializer

import com.soywiz.klock.hours
import com.soywiz.klock.minutes
import de.jlnstrk.transit.util.ZoneOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object HciZoneOffsetSerializer : KSerializer<ZoneOffset> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ZoneOffset", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: ZoneOffset) {
        encoder.encodeInt(value.totalMinutesInt)
    }

    override fun deserialize(decoder: Decoder): ZoneOffset {
        val value = decoder.decodeInt()
        val hours = value / 60
        val minutes = value % 60
        return ZoneOffset(hours.hours + minutes.minutes)
    }
}