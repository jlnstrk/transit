package de.jlnstrk.transit.client.hci.method.locgeoreach

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciReachPos
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciLocGeoReachServiceResult(
  public val common: HciCommon? = null,
  public val mapLayX: Int? = null,
  public val posL: List<HciReachPos> = emptyList(),
) : HciServiceResult()
