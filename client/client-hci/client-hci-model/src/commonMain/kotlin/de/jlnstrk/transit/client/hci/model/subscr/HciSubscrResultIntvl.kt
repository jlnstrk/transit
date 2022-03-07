package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrResultIntvl(
  public val arrLoc: HciLocation,
  public val ctxRecon: String? = null,
  public val depLoc: HciLocation,
  public val language: String? = null,
  public val maxChg: Int? = null,
  public val minChgTime: Int? = null,
  public val period: Int,
  public val status: HciSubscrStatus,
  public val subscrId: Int,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime,
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val viaLocL: List<HciLocation> = emptyList()
)
