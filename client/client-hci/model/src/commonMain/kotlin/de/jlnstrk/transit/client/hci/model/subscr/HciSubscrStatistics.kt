package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrStatistics(
  public val `data`: String? = null,
  public val hysteresis: HciSubscrHysteresisCon? = null,
  public val serviceDays: HciSubscrDays? = null,
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val monitorFlags: List<HciSubscrMonitorFlags> = emptyList(),
  public val stPairL: List<HciSubscrStationPair> = emptyList(),
  public val regExtId: Int = 0
)
