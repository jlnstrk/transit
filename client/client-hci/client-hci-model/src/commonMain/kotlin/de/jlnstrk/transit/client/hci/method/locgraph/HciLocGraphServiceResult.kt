package de.jlnstrk.transit.client.hci.method.locgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciLine
import de.jlnstrk.transit.client.hci.model.HciProductGraph
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLocGraphServiceResult(
  public val common: HciCommon? = null,
  public val lineL: List<HciLine> = emptyList(),
  public val locStartEndRefL: List<Int> = emptyList(),
  public val locStopRefL: List<Int> = emptyList(),
  public val prodGraphL: List<HciProductGraph> = emptyList()
) : HciServiceResult()
