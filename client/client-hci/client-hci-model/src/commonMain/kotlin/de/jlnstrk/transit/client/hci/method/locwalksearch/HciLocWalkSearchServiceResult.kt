package de.jlnstrk.transit.client.hci.method.locwalksearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocationWalk
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLocWalkSearchServiceResult(
  public val common: HciCommon? = null,
  public val locWalkL: List<HciLocationWalk> = emptyList(),
) : HciServiceResult()
