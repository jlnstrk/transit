@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.endpoint.stopfinder

import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaResponse
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaStopFinderResponse(
    public val stopFinder: EfaPointVerification
) : EfaResponse()