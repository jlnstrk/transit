package de.jlnstrk.transit.client.hci.model.struct

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciStructGraphNode(
  public val coord: HciCoord? = null,
  public val id: String? = null,
  public val locX: Int? = null,
  public val mainNodeX: Int = -1,
  public val name: String? = null,
  public val type: HciStructGraphNodeType? = null
)
