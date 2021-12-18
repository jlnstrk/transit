package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciColor(
    /** The red component of this color */
    public val r: Int,

    /** The green component of this color */
    public val g: Int,

    /** The blue component of this color */
    public val b: Int
)