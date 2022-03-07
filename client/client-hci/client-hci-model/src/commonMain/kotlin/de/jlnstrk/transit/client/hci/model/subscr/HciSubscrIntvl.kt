package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrIntvl(
  public val arrLoc: HciLocation,
  public val ctxRecon: String? = null,
  public val depLoc: HciLocation,
  public val hysteresis: HciSubscrHysteresisCon? = null,
  public val maxChg: Int? = null,
  public val minChgTime: Int? = null,
  public val negativeAttributes: String? = null,
  public val period: Int,
  public val positiveAttributes: String? = null,
  public val serviceDays: HciSubscrDays,
  public val serviceDensityNumberThreshold: Int? = null,
  public val serviceDensityWaittimeThreshold: Int? = null,
  public val startChildrenImmediately: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val time: HciLocalTime,
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val monitorFlags: List<HciSubscrMonitorFlags> = emptyList(),
  public val viaLocL: List<HciLocation> = emptyList()
)
