package de.jlnstrk.transit.client.hci.method.subscrchannelupdate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannel
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannelUpdateServiceRequest(
  public var channel: HciSubscrChannel? = null,
  public var userId: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrChannelUpdateServiceRequest.() -> Unit):
        HciSubscrChannelUpdateServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrchannelupdate.HciSubscrChannelUpdateServiceRequest().apply(init)
  }
}
