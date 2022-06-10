package de.jlnstrk.transit.client.efa.serializer.primitive.datetime

import de.jlnstrk.transit.client.efa.util.EFA_DATETIME_FORMAT_SPACE_SEP
import de.jlnstrk.transit.client.efa.util.EFA_DATE_FORMAT_DOT_SEP
import de.jlnstrk.transit.client.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.client.efa.util.EFA_TIME_FORMAT_COLON_SEP
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaStringDateTimeSerializer {

    internal object DateTime : KSerializer<LocalDateTime> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("DateTime", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: LocalDateTime) {
            val string = EFA_DATETIME_FORMAT_SPACE_SEP.formatDateTime(value)
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): LocalDateTime {
            val string = decoder.decodeString()
            return EFA_DATETIME_FORMAT_SPACE_SEP.parseDateTime(string)
        }
    }

    internal object Date : KSerializer<LocalDate> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: LocalDate) {
            val string = EFA_DATE_FORMAT_NO_SEP.formatInstant(value)
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): LocalDate {
            val string = decoder.decodeString()
            val formatter = if (string.length == 8) EFA_DATE_FORMAT_NO_SEP else EFA_DATE_FORMAT_DOT_SEP
            return formatter.parseDate(string)
        }
    }

    internal object Time : KSerializer<LocalTime> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("Time", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: LocalTime) {
            val string = EFA_TIME_FORMAT_COLON_SEP.formatTime(value)
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): LocalTime {
            val string = decoder.decodeString()
            return EFA_TIME_FORMAT_COLON_SEP.parseTime(string)
        }
    }
}