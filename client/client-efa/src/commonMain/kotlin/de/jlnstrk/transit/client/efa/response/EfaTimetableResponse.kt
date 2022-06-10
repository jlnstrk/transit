@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.response

import de.jlnstrk.transit.client.efa.endpoint.dm.EfaDmResponse
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaFlatObjectDateTimeSerializer
import kotlinx.datetime.LocalDate
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