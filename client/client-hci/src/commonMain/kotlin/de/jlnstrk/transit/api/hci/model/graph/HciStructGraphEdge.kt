package de.jlnstrk.transit.api.hci.model.graph

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStructGraphEdge(
    public val id: String?,
    public val fromNodeX: Int,
    public val toNodeX: Int,
)