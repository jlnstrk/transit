package de.jlnstrk.transit.client.hapi.serializer

import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

internal object HapiDurationSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Duration", PrimitiveKind.STRING)

    @OptIn(ExperimentalTime::class)
    override fun serialize(encoder: Encoder, value: Duration) {
        val string = kotlin.time.Duration.milliseconds(value.millisecondsLong).toIsoString()
        encoder.encodeString(string)
    }

    @OptIn(ExperimentalTime::class)
    override fun deserialize(decoder: Decoder): Duration {
        return kotlin.time.Duration.parse(decoder.decodeString())
            .let { Duration(it.toDouble(DurationUnit.MILLISECONDS)) }
    }
}