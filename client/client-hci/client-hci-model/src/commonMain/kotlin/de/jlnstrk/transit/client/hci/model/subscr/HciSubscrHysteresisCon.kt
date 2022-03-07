package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrHysteresisCon(
  public val blockEarliness: Boolean? = null,
  public val himFltrL: List<HciHimFilter> = emptyList(),
  public val longTermNotificationInterval: Int? = null,
  public val longTermNotificationStart: Int? = null,
  public val maxWaittimeForLastSections: Int? = null,
  public val minChangeTimeBuffer: Int? = null,
  public val minDeviationFollowing: Int? = null,
  public val minDeviationInterval: Int? = null,
  public val minNegativeDeviationFollowing: Int? = null,
  public val minNegativeDeviationInterval: Int? = null,
  public val notificationStart: Int? = null,
  public val notifyArrivalPreviewTime: Int? = null,
  public val notifyDepartureWithoutRT: Int? = null
)
