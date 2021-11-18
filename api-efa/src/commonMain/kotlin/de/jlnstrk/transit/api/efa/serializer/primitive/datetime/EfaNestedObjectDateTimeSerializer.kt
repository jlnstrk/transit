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
        val itdDate: EfaFlatObjectDateTimeSerializer.Intermediate,
        val itdTime: EfaFlatObjectDateTimeSerializer.Intermediate
    )

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        val intermediate = Intermediate(
            itdDate = EfaFlatObjectDateTimeSerializer.Intermediate(
                year = value.yearInt,
                month = value.month0,
                day = value.dayOfMonth
            ),
            itdTime = EfaFlatObjectDateTimeSerializer.Intermediate(
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
            intermediate.itdDate.year,
            intermediate.itdDate.month,
            intermediate.itdDate.day,
            intermediate.itdTime.hour,
            intermediate.itdTime.minute,
            intermediate.itdTime.second
        )
    }
}