package de.jlnstrk.transit.api.efa.serializer

import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.response.EfaTimeHeader
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object EfaTimeHeaderSerializer : KSerializer<EfaTimeHeader> {
    override val descriptor: SerialDescriptor = Intermediate.serializer().descriptor

    @Serializable
    class Intermediate(
        val deparr: EfaRequest.DateTimeMode,
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
            value.dateTime.yearInt,
            value.dateTime.month0,
            value.dateTime.dayOfMonth,
            value.dateTime.hours,
            value.dateTime.minutes
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