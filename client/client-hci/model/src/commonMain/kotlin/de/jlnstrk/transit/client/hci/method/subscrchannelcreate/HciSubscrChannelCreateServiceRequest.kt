package de.jlnstrk.transit.client.hci.method.subscrchannelcreate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannelOption
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrChannelType
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrType
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrChannelCreateServiceRequest(
  public var address: String? = null,
  public var channelId: String? = null,
  public var language: String? = null,
  public var name: String? = null,
  public var type: HciSubscrChannelType? = null,
  public var userId: String? = null,
  public var options: List<HciSubscrChannelOption> = emptyList(),
  public var subscrTypes: List<HciSubscrType> = emptyList(),
  public var active: Boolean? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrChannelCreateServiceRequest.() -> Unit):
        HciSubscrChannelCreateServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrchannelcreate.HciSubscrChannelCreateServiceRequest().apply(init)
  }
}
