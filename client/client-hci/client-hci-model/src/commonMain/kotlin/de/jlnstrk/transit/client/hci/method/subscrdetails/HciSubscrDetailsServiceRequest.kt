package de.jlnstrk.transit.client.hci.method.subscrdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannelType
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrDetailsServiceRequest(
  public var channelId: String? = null,
  public var channelType: HciSubscrChannelType? = null,
  public var eventsFrom: String? = null,
  public var subscrId: Int? = null,
  public var userId: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrDetailsServiceRequest.() -> Unit):
        HciSubscrDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrdetails.HciSubscrDetailsServiceRequest().apply(init)
  }
}
