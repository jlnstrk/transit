package de.jlnstrk.transit.api.efa.serializer.primitive.datetime

import com.soywiz.klock.format
import com.soywiz.klock.parseDate
import com.soywiz.klock.parseTime
import com.soywiz.klock.parseUtc
import de.jlnstrk.transit.api.efa.util.EFA_DATETIME_FORMAT_SPACE_SEP
import de.jlnstrk.transit.api.efa.util.EFA_DATE_FORMAT_DOT_SEP
import de.jlnstrk.transit.api.efa.util.EFA_DATE_FORMAT_NO_SEP
import de.jlnstrk.transit.api.efa.util.EFA_TIME_FORMAT_COLON_SEP
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.LocalTime
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
            val string = EFA_DATETIME_FORMAT_SPACE_SEP.format(value)
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): LocalDateTime {
            val string = decoder.decodeString()
            return EFA_DATETIME_FORMAT_SPACE_SEP.parseUtc(string)
        }
    }

    internal object Date : KSerializer<LocalDate> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: LocalDate) {
            val string = EFA_DATE_FORMAT_NO_SEP.format(value)
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
            val string = EFA_TIME_FORMAT_COLON_SEP.format(value)
            encoder.encodeString(string)
        }

        override fun deserialize(decoder: Decoder): LocalTime {
            val string = decoder.decodeString()
            return EFA_TIME_FORMAT_COLON_SEP.parseTime(string)
        }
    }
}