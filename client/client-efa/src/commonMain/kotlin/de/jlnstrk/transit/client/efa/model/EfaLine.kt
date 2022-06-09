@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaLine(
    /** Whether this line was selected in the request */
    public val selected: String,

    /** The line number */
    public val number: String?,

    /** The line name */
    public val name: String?,

    /** Returns a supplement */
    public val supplement: String?,

    /** The code for the direction of this line */
    public val direction: String?,

    /** Returns a readable name of the direction of this line */
    public val directionName: String?,

    /** Returns an alternate readable name of the direction of this line */
    public val directionText: EfaDirectionText?,

    // TODO: Purpose?
    public val partialNet: String?,

    /** The means of transport of this line */
    public val motType: EfaMeansOfTransport?,

    // TODO: Purpose?
    // This is an alternate mapping of means and correlates to the mode-related attrs in EfaPin
    public val motCode: Int,

    /** The product id of this line */
    public val productId: Int,

    /** Returns a readable description of the important stops on the route of this line */
    public val routeDescText: String?,

    /** The operator of this line */
    public val itdOperator: EfaOperator?
)

@Serializable
public data class EfaDirectionText(
    public val text: String
)