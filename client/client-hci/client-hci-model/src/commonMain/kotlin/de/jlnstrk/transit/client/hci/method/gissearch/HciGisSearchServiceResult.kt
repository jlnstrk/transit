package de.jlnstrk.transit.client.hci.method.gissearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciRoutingPreselection
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciGisSearchServiceResult(
  public val preselectionL: List<HciRoutingPreselection> = emptyList(),
  public val refLoc: HciLocation? = null,
) : HciServiceResult()
