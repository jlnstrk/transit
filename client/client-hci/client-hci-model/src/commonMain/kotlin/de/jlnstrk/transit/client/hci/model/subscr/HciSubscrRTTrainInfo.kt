package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRTTrainInfo(
  public val arrStop: HciSubscrRTStopInfo,
  public val depStop: HciSubscrRTStopInfo,
  public val lastStop: HciSubscrRTStopInfo? = null,
  public val pos: HciCoord? = null,
  public val himEvents: List<HciSubscrEventHIM> = emptyList(),
  public val hasRT: Boolean = false
)
