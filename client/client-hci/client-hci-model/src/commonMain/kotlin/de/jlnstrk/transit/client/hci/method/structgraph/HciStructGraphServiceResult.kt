package de.jlnstrk.transit.client.hci.method.structgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciStructGraphServiceResult(
  public val common: HciCommon? = null,
  public val edgeRefL: List<Int> = emptyList(),
  public val rect: HciGeoRect? = null
) : HciServiceResult()
