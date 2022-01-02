package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrDetails(
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val conSubscr: HciSubscrCon? = null,
  public val eventHistory: HciSubscrEventHistory? = null,
  public val externalId: String? = null,
  public val intvlSubscr: HciSubscrIntvl? = null,
  public val jnySubscr: HciSubscrJourney? = null,
  public val language: String? = null,
  public val nPass: Int? = null,
  public val rssSubscr: HciSubscrRSS? = null,
  public val statSubscr: HciSubscrStatistics? = null,
  public val status: HciSubscrStatus,
  public val subscrId: Int,
  public val userId: String
)
