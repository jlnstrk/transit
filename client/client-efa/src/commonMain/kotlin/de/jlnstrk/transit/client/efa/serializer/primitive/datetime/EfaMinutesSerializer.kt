package de.jlnstrk.transit.client.efa.serializer.primitive.datetime

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

internal object EfaMinutesSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(EfaMinutesSerializer::class.simpleName!!, PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: Duration) {
        val hrs = value.inWholeHours
        val min = value.inWholeMinutes % 60L
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