package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrJourney(
  public val aLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTime: HciLocalTime? = null,
  public val dLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTime: HciLocalTime? = null,
  public val `data`: String? = null,
  public val hysteresis: HciSubscrHysteresisCon? = null,
  public val jid: String,
  public val prodName: String? = null,
  public val serviceDays: HciSubscrDays,
  public val triggerPt: HciSubscrTriggerPoint? = null,
  public val monitorFlags: List<HciSubscrMonitorFlags> = emptyList(),
  public val eventCount: Int = 0
)
