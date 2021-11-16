@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.response

import de.jlnstrk.transit.api.efa.serializer.generic.EfaMapListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public abstract class EfaResponse {
    /** The generic request and server parameters of this response */
    @Serializable(with = EfaMapListSerializer::class)
    public val parameters: Map<Parameter, String> = emptyMap()

    @Serializable
    public enum class Parameter {
        @SerialName("serverID")
        SERVER_ID,

        @SerialName("serverTime")
        SERVER_TIME,

        @SerialName("calcTime")
        CALCULATION_TIME,

        @SerialName("sessionID")
        SESSION_ID,

        @SerialName("requestID")
        REQUEST_ID
    }
}