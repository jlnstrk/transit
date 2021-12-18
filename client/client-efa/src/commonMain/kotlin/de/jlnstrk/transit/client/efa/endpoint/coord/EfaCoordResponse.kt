@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.endpoint.coord

import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.client.efa.model.EfaPin
import de.jlnstrk.transit.client.efa.response.EfaResponse
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaCoordResponse(
    public val request: Request,
    public val pins: List<EfaPin>
) : EfaResponse() {

    @Serializable
    public class Request(
        public val coords: EfaCoordinates
    )
}