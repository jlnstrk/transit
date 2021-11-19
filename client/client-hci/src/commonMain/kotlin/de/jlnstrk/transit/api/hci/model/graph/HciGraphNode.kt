package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGraphNode(
    /** The graph of this node */
    public val graphX: Int,

    /** The child nodes of this node */
    public val subGraphNodes: List<HciSubGraphNode> = emptyList(),
)