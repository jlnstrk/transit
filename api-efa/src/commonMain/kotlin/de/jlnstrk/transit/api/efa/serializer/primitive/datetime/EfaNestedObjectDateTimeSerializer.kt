package de.jlnstrk.transit.api.efa.serializer.primitive.datetime

import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaNestedObjectDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

    @Serializable
    class Intermediate(
        @SerialName("itdDate")
        val date: EfaFlatObjectDateTimeSerializer.Intermediate,
        @SerialName("itdTime")
        val time: EfaFlatObjectDateTimeSerializer.Intermediate
    )

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        val intermediate = Intermediate(
            date = EfaFlatObjectDateTimeSerializer.Intermediate(
                year = value.yearInt,
                month = value.month0,
                day = value.dayOfMonth
            ),
            time = EfaFlatObjectDateTimeSerializer.Intermediate(
                hour = value.hours,
                minute = value.minutes,
                second = value.seconds
            )
        )
        Intermediate.serializer().serialize(encoder, intermediate)
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val intermediate = Intermediate.serializer().deserialize(decoder)
        return LocalDateTime(
            intermediate.date.year,
            intermediate.date.month,
            intermediate.date.day,
            intermediate.time.hour,
            intermediate.time.minute,
            intermediate.time.second
        )
    }
}