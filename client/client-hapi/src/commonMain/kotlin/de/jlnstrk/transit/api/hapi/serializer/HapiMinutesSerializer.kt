package de.jlnstrk.transit.api.hapi.serializer

import com.soywiz.klock.minutes
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.math.roundToInt

internal object HapiMinutesSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Minutes", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Duration) {
        encoder.encodeInt(value.minutes.roundToInt())
    }

    override fun deserialize(decoder: Decoder): Duration {
        return decoder.decodeInt().minutes
    }
}