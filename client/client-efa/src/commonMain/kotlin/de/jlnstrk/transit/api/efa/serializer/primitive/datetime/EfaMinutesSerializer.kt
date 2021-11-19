package de.jlnstrk.transit.api.efa.serializer.primitive.datetime

import com.soywiz.klock.hours
import com.soywiz.klock.minutes
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaMinutesSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(EfaMinutesSerializer::class.simpleName!!, PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: Duration) {
        val hrs = value.hours.toLong()
        val min = value.minutes.toLong() % 60L
        encoder.encodeString("$hrs:$min")
    }

    override fun deserialize(decoder: Decoder): Duration {
        val parts = decoder.decodeString().split(":")
        if (parts.size == 2) {
            val (hrs, min) = parts
            return hrs.toLong().hours + min.toLong().minutes
        }
        return parts[0].toLong().minutes
    }
}