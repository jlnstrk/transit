package de.jlnstrk.transit.client.hci.method.journeygraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciProductGraph
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyGraphServiceResult(
  public val common: HciCommon? = null,
  public val locStartEndRefL: List<Int> = emptyList(),
  public val locStopRefL: List<Int> = emptyList(),
  public val prodGraphL: List<HciProductGraph> = emptyList(),
) : HciServiceResult()
