package de.jlnstrk.transit.client.hci.method.subscrchanneldelete

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannelDeleteServiceRequest(
  public var channelId: String? = null,
  public var userId: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrChannelDeleteServiceRequest.() -> Unit):
        HciSubscrChannelDeleteServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrchanneldelete.HciSubscrChannelDeleteServiceRequest().apply(init)
  }
}
