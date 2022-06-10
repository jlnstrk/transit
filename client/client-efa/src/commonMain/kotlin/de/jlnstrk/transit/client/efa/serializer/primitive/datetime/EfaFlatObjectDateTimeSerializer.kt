package de.jlnstrk.transit.client.efa.serializer.primitive.datetime

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaFlatObjectDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

    object JustDate : KSerializer<LocalDate> {
        override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

        override fun serialize(encoder: Encoder, value: LocalDate) {
            val intermediate = Intermediate(
                value.year,
                value.monthNumber,
                value.dayOfMonth
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
            year = value.year,
            month = value.monthNumber,
            day = value.dayOfMonth,
            hour = value.hour,
            minute = value.minute,
            second = value.second
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