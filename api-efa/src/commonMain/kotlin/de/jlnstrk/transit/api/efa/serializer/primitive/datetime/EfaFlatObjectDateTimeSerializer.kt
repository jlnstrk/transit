package de.jlnstrk.transit.api.efa.serializer.primitive.datetime

import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = LocalDateTime::class)
internal object EfaFlatObjectDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

    object JustDate : KSerializer<LocalDate> {
        override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

        override fun serialize(encoder: Encoder, value: LocalDate) {
            val intermediate = Intermediate(
                value.year,
                value.month.index0,
                value.day
            )
            Intermediate.serializer().serialize(encoder, intermediate)
        }

        override fun deserialize(decoder: Decoder): LocalDate {
            val intermediate = Intermediate.serializer().deserialize(decoder)
            return LocalDate(
                intermediate.year,
                intermediate.month,
                intermediate.day
            )
        }
    }

    @Serializable
    internal class Intermediate(
        val year: Int = 0,
        val month: Int = 0,
        val day: Int = 0,
        val weekday: Int = 0,
        val hour: Int = 0,
        val minute: Int = 0,
        val second: Int = 0
    )

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        val intermediate = Intermediate(
            year = value.yearInt,
            month = value.month0,
            day = value.dayOfMonth,
            hour = value.hours,
            minute = value.minutes,
            second = value.seconds
        )
        Intermediate.serializer().serialize(encoder, intermediate)
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val intermediate = Intermediate.serializer().deserialize(decoder)
        return LocalDateTime(
            intermediate.year,
            intermediate.month,
            intermediate.day,
            intermediate.hour,
            intermediate.minute,
            intermediate.second
        )
    }
}