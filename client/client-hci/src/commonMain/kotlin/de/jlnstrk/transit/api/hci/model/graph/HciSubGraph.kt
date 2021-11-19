package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciSubGraph(
    /** The id of this subgraph */
    public val id: String,

    /** The index of this subgraph */
    public val index: Int,

    /** The name of this subgraph */
    public val name: String?,
)