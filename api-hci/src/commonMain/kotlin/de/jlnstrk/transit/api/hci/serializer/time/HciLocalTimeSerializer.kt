package de.jlnstrk.transit.api.hci.serializer.time

import com.soywiz.klock.TimeFormat
import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.api.hci.model.base.HciLocalTime
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object HciLocalTimeSerializer : KSerializer<LocalTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalTime", PrimitiveKind.STRING)
    private val TIME_FORMATTER = TimeFormat("HHmmss")

    override fun serialize(encoder: Encoder, value: LocalTime) {
        val string = TIME_FORMATTER.format(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): LocalTime {
        val string = decoder.decodeString()
        return TIME_FORMATTER.parseTime(string)
    }

    internal object WithDayOffset : KSerializer<HciLocalTime> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("HciLocalTime", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: HciLocalTime) {
            val timeString = TIME_FORMATTER.format(value.time)
            val string = value.offsetDays.toString().padStart(2, '0') + timeString
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): HciLocalTime {
            val string = decoder.decodeString()
            val timePart = string.substring(string.length - 6, string.length)
            val time = TIME_FORMATTER.parseTime(timePart)
            val offsetDays = if (string.length == 8) string.substring(0, 2).toInt() else 0
            return HciLocalTime(time = time, offsetDays = offsetDays)
        }
    }
}