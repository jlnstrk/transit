package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyPath(
  public val polyG: HciPolylineGroup? = null,
  public val dirGeo: List<Int> = emptyList(),
  public val fLocX: List<Int> = emptyList(),
  public val mSec: List<Int> = emptyList(),
  public val proc: List<Int> = emptyList(),
  public val procAbs: List<Int> = emptyList(),
  public val state: List<HciJourneyPathState> = emptyList(),
  public val stcOutputX: List<Int> = emptyList(),
  public val structGraphEdgeProc: List<Int> = emptyList(),
  public val structGraphEdgeX: List<Int> = emptyList(),
  public val tLocX: List<Int> = emptyList(),
)
