package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciCoord(
  public val floor: Int? = null,
  public val x: Int,
  public val y: Int,
  public val viewAlternatives: List<HciGraphNode> = emptyList(),
  public val z: Int = 99999999,
  public val layerX: Int = 0,
  public val crdSysX: Int = 0,
)
