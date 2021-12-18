@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public enum class EfaCoordinateSystem {
    @SerialName("NAV3")
    NAV3,

    @SerialName("NAV4")
    NAV4,

    @SerialName("MDV")
    MDV,

    @SerialName("WGS84[DD.ddddd]")
    WGS84_DECIMAL,

    @SerialName("WGS84")
    WGS84,
}