package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationWalk(
  public val extId: Int,
  public val fLocX: Int? = null,
  public val polyG: HciPolylineGroup? = null,
  public val tLocX: Int? = null,
  public val himXL: List<Int> = emptyList(),
  public val remXL: List<Int> = emptyList()
)
