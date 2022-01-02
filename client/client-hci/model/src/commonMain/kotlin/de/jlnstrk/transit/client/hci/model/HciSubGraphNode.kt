package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubGraphNode(
  public val subGraphX: Int,
  public val viewNodes: List<HciViewNode> = emptyList()
)
