package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGraphNode(
  public val graphX: Int,
  public val subGraphNodes: List<HciSubGraphNode> = emptyList(),
)
