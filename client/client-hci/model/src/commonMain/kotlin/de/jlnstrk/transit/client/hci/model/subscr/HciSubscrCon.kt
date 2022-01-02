package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrCon(
  public val ctxRecon: String,
  public val `data`: String? = null,
  public val hysteresis: HciSubscrHysteresisCon? = null,
  public val negativeAttributes: String? = null,
  public val notifyArrival: Boolean = false,
  public val notifyDeparture: Boolean = false,
  public val positiveAttributes: String? = null,
  public val serviceDays: HciSubscrDays,
  public val withIStops: Boolean = false,
  public val connectionInfo: List<HciSubscrConSecInfo> = emptyList(),
  public val monitorFlags: List<HciSubscrMonitorFlags> = emptyList(),
  public val notifyArrivalPreviewTime: Int = 10
)
