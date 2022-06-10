package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciProductStatus
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTreeNode(
  public val icoX: Int? = null,
  public val name: String? = null,
  public val parRefX: Int? = null,
  public val pid: String,
  public val prodX: Int? = null,
  public val stat: HciProductStatus? = null,
  public val type: HciJourneyTreeNodeType,
  public val childRefL: List<Int> = emptyList(),
  public val himIdL: List<String> = emptyList(),
  public val level: Int = -1,
)
