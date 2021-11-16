package de.jlnstrk.transit.api.hci.model.geo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciLayer(
    /** The id of this layer */
    public val id: String,

    /** The name of this layer */
    public val name: String,

    /** The index of this layer */
    public val index: Int,

    /** The number of annotations associated with this layer */
    public val annoCnt: Int
)