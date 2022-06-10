package de.jlnstrk.transit.client.efa.serializer.primitive.datetime

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
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
                year = value.year,
                month = value.monthNumber,
                day = value.dayOfMonth
            ),
            itdTime = EfaFlatObjectDateTimeSerializer.Intermediate(
                hour = value.hour,
                minute = value.minute,
                second = value.second
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