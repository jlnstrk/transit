package de.jlnstrk.transit.client.hci.method.userstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciUserStoreServiceRequest(
  public var user: HciUser? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciUserStoreServiceRequest.() -> Unit):
        HciUserStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.userstore.HciUserStoreServiceRequest().apply(init)
  }
}
