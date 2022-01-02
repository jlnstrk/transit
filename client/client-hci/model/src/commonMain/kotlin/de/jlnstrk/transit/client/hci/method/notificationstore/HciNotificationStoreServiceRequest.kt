package de.jlnstrk.transit.client.hci.method.notificationstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciNotification
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciNotificationStoreServiceRequest(
  public var notification: HciNotification? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciNotificationStoreServiceRequest.() -> Unit):
        HciNotificationStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.notificationstore.HciNotificationStoreServiceRequest().apply(init)
  }
}
