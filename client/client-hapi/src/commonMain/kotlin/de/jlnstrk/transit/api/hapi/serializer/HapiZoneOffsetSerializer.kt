package de.jlnstrk.transit.api.hapi.serializer

import com.soywiz.klock.minutes
import de.jlnstrk.transit.util.ZoneOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HapiZoneOffsetSerializer : KSerializer<ZoneOffset> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ZoneOffset", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: ZoneOffset) {
        encoder.encodeInt(value.totalMinutesInt)
    }

    override fun deserialize(decoder: Decoder): ZoneOffset {
        return ZoneOffset(decoder.decodeInt().minutes)
    }
}