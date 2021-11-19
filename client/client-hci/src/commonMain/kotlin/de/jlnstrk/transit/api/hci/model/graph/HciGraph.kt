package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGraph(
    /** The id of this graph */
    public val id: String,

    /** The index of this graph */
    public val index: Int,

    /** The name of this graph */
    public val name: String?,
)