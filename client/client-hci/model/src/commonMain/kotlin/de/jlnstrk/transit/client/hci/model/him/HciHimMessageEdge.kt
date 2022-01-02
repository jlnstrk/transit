package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessageEdge(
  public val fLocX: Int? = null,
  public val icoCrd: HciCoord? = null,
  public val icoX: Int? = null,
  public val polyG: HciPolylineGroup? = null,
  public val tLocX: Int? = null,
  public val msgRefL: List<Int> = emptyList(),
  public val dir: Int = 0
)
