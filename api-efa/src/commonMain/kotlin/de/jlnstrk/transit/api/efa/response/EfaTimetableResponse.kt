@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.response

import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmResponse
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaFlatObjectDateTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public abstract class EfaTimetableResponse : EfaResponse() {
    public lateinit var dateTime: EfaTimeHeader
        private set
    public lateinit var dateRange: List<@Serializable(with = EfaFlatObjectDateTimeSerializer.JustDate::class) LocalDate>
        private set
    public lateinit var option: EfaDmResponse.Options
        private set
}