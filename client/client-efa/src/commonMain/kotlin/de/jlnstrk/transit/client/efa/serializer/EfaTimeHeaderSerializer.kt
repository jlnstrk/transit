package de.jlnstrk.transit.client.efa.serializer

import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.response.EfaTimeHeader
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaTimeHeaderSerializer : KSerializer<EfaTimeHeader> {
    override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

    @Serializable
    class Intermediate(
        val deparr: EfaDateTimeMode,
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        val ttpFrom: LocalDate,
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        val ttpTo: LocalDate,
        val year: Int,
        val month: Int,
        val day: Int,
        val hour: Int,
        val minute: Int
    )

    override fun serialize(encoder: Encoder, value: EfaTimeHeader) {
        val intermediate = Intermediate(
            value.mode,
            value.timetableFrom,
            value.timetableTo,
            value.dateTime.year,
            value.dateTime.monthNumber,
            value.dateTime.dayOfMonth,
            value.dateTime.hour,
            value.dateTime.minute
        )
        Intermediate.serializer().serialize(encoder, intermediate)
    }

    override fun deserialize(decoder: Decoder): EfaTimeHeader {
        val intermediate = Intermediate.serializer().deserialize(decoder)
        return EfaTimeHeader(
            intermediate.deparr, intermediate.ttpFrom, intermediate.ttpTo,
            LocalDateTime(
                intermediate.year,
                intermediate.month,
                intermediate.day,
                intermediate.hour,
                intermediate.minute
            )
        )
    }
}