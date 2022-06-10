package de.jlnstrk.transit.client.hci.method.subscruserupdate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannel
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrHysteresisCon
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrUserUpdateServiceRequest(
  public var availableChannels: List<HciSubscrChannel> = emptyList(),
  public var channels: List<HciSubscrChannel> = emptyList(),
  public var getDetails: Boolean? = null,
  public var hysteresis: HciSubscrHysteresisCon? = null,
  public var language: String? = null,
  public var pauseBegin: String? = null,
  public var pauseEnd: String? = null,
  public var userId: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrUserUpdateServiceRequest.() -> Unit):
        HciSubscrUserUpdateServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscruserupdate.HciSubscrUserUpdateServiceRequest().apply(init)
  }
}
