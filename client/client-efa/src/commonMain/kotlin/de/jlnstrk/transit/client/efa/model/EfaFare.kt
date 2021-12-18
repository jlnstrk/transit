@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.generic.EfaMapListSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaFare(
    /** The network that this fare applies to */
    public val net: String,

    // TODO: Purpose?
    public val fromPR: Int,

    // TODO: Purpose?
    public val toPR: Int,

    // TODO: Strong type
    /** The currency of the individual prices */
    public val currency: String,

    /** The name of the used unit */
    public val unitName: String?,

    /** The fare for adults, if available */
    public val fareAdult: Float?,

    /**  The unit for adults, if available */
    public val unitsAdult: String?,

    /** The fare for children, if present */
    public val fareChild: Float?,

    /** The unit for children, if present */
    public val unitsChild: String?,

    /** The fare for adults with bicycle carriage, if present */
    public val fareBikeAdult: Float?,

    /** The unit for adults with bicycle carriage, if present */
    public val unitsBikeAdult: String?,

    /** The fare for children with bicycle carriage, if present */
    public val fareBikeChild: Float?,

    /** The unit for children with bicycle carriage, if present */
    public val unitsBikeChild: String?,

    // TODO: Purpose?
    public val levelAdult: String?,

    // TODO: Purpose?
    public val levelChild: String?,

    // TODO: Purpose?
    public val idAdult: String?,

    // TODO: Purpose?
    public val idChild: String?,

    /** The note attached to this fare */
    public val note: String?,

    // TODO: Dive deeper
    @Serializable(with = EfaMapListSerializer::class)
    public val genericTickets: Map<String, String>?
)