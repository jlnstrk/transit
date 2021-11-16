@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.response

import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.api.efa.serializer.EfaTimeHeaderSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable(with = EfaTimeHeaderSerializer::class)
public data class EfaTimeHeader(
    public val mode: EfaRequest.DateTimeMode,
    public val timetableFrom: LocalDate,
    public val timetableTo: LocalDate,
    public val dateTime: LocalDateTime
)