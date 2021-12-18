@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.response

import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.client.efa.serializer.EfaTimeHeaderSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable(with = EfaTimeHeaderSerializer::class)
public data class EfaTimeHeader(
    public val mode: EfaDateTimeMode,
    public val timetableFrom: LocalDate,
    public val timetableTo: LocalDate,
    public val dateTime: LocalDateTime,
)