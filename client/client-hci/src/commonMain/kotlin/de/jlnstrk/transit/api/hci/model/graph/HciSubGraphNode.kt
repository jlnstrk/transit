package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciSubGraphNode(
    /** The subgraph of this node belongs to */
    public val subGraphX: Int,

    /** The view nodes of this subgraph */
    public val viewNodes: List<HciViewNode> = emptyList()
)