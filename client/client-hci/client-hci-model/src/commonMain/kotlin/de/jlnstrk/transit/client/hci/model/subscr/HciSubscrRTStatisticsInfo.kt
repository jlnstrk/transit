package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFreq
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRTStatisticsInfo(
  public val himEvents: List<HciSubscrEventHIM> = emptyList(),
  public val serviceDensity: HciJourneyFreq? = null
)
