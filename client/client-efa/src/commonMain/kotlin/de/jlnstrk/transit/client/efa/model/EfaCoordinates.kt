@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForInt::class,
    EfaPrimitiveSerializer.ForLong::class,
    EfaPrimitiveSerializer.ForFloat::class,
    EfaPrimitiveSerializer.ForDouble::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaCoordinates(
    /** The x-coordinate */
    public val x: Double,

    /** The y-coordinate */
    public val y: Double,

    /** The coordinate system used */
    public val mapName: EfaCoordinateSystem,
)