package de.jlnstrk.transit.api.hci.serializer.time

import com.soywiz.klock.days
import com.soywiz.klock.hours
import com.soywiz.klock.minutes
import com.soywiz.klock.seconds
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HciDurationSerializer : KSerializer<Duration> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Duration", PrimitiveKind.STRING)
    private const val FORMAT = "%02d%02d%02d%02d"

    override fun serialize(encoder: Encoder, value: Duration) {
        val string = StringBuilder().apply {
            append(value.days.toLong().toString().padStart(2, '0'))
            append((value.hours.toLong() % 24).toString().padStart(2, '0'))
            append((value.minutes.toLong() % 60).toString().padStart(2, '0'))
            append((value.seconds.toLong() % 60).toString().padStart(2, '0'))
        }.toString()
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): Duration {
        val string = decoder.decodeString()
        val seconds = string.substring(string.length - 2, string.length).toLong()
        val minutes = string.substring(string.length - 4, string.length - 2).toLong()
        val hours = string.substring(string.length - 6, string.length - 4).toLong()
        val days = if (string.length == 8) {
            string.substring(0, 2).toLong(9)
        } else 0
        return days.days + hours.hours + minutes.minutes + seconds.seconds
    }
}