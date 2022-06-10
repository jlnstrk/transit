package de.jlnstrk.transit.client.hapi.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal object HapiSecondsSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Seconds", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Duration) {
        encoder.encodeInt(value.inWholeSeconds.toInt())
    }

    override fun deserialize(decoder: Decoder): Duration {
        return decoder.decodeInt().seconds
    }
}