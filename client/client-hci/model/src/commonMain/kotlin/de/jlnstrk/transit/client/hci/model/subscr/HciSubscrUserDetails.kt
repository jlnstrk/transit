package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrUserDetails(
  public val availableChannels: List<HciSubscrChannel> = emptyList(),
  public val channels: List<HciSubscrChannel> = emptyList(),
  public val hysteresis: HciSubscrHysteresisCon? = null,
  public val language: String? = null,
  public val pauseBegin: String? = null,
  public val pauseEnd: String? = null,
  public val userId: String
)
