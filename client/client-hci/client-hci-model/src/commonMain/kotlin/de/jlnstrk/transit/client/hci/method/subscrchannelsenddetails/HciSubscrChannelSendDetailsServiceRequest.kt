package de.jlnstrk.transit.client.hci.method.subscrchannelsenddetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannelType
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannelSendDetailsServiceRequest(
  public var address: String? = null,
  public var channelType: HciSubscrChannelType? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrChannelSendDetailsServiceRequest.() -> Unit):
        HciSubscrChannelSendDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrchannelsenddetails.HciSubscrChannelSendDetailsServiceRequest().apply(init)
  }
}
