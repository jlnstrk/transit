package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrResultStatistics(
  public val language: String? = null,
  public val status: HciSubscrStatus,
  public val subscrId: Int,
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val stPairL: List<HciSubscrStationPair> = emptyList(),
  public val regExtId: Int = 0,
)
