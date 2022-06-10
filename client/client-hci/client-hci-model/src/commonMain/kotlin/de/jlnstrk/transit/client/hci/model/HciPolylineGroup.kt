package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPolylineGroup(
  public val polyXL: List<Int> = emptyList(),
  public val viewAlternatives: List<HciGraphNode> = emptyList(),
)
