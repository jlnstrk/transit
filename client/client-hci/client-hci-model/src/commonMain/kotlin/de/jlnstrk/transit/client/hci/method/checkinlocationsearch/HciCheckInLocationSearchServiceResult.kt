package de.jlnstrk.transit.client.hci.method.checkinlocationsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciCheckInLocationSearchServiceResult(
  public val common: HciCommon? = null,
  public val locL: List<HciLocation> = emptyList()
) : HciServiceResult()
