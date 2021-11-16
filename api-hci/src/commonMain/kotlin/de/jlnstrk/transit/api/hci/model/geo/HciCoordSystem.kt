package de.jlnstrk.transit.api.hci.model.geo

import de.jlnstrk.transit.api.hci.config.HciAtMost
import kotlinx.serialization.Serializable

@HciAtMost("1.24")
@Serializable
public data class HciCoordSystem(
    /** The index of this coordinate system */
    public val index: Int = 0,

    /** The id of this coordinate system */
    public val id: String?,

    /** The name of this coordinate system */
    public val name: String?,

    /** The picture of this coordinate system */
    public val picture: String?,

    /** The type of this coordinate system */
    public val type: HciCoord.Type,

    /** The number of dimensions used in this coordinate system */
    public val dim: Int?
)