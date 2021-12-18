package de.jlnstrk.transit.client.trias.serializer

import com.soywiz.klock.TimeSpan
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = Duration::class)
public object DurationSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Duration", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Duration) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): Duration {
        // TODO
        return TimeSpan(0.0)
    }
}