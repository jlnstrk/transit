@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.endpoint.stopfinder

import de.jlnstrk.transit.client.efa.response.EfaPointVerification
import de.jlnstrk.transit.client.efa.response.EfaResponse
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaStopFinderResponse(
    public val stopFinder: EfaPointVerification
) : EfaResponse()