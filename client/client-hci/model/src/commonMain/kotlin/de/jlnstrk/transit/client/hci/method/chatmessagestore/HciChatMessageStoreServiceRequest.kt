package de.jlnstrk.transit.client.hci.method.chatmessagestore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.chat.HciChatMessage
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciChatMessageStoreServiceRequest(
  public var msg: HciChatMessage? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciChatMessageStoreServiceRequest.() -> Unit):
        HciChatMessageStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.chatmessagestore.HciChatMessageStoreServiceRequest().apply(init)
  }
}
