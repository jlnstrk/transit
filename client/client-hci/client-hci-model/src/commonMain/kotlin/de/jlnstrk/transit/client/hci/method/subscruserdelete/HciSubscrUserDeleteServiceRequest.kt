package de.jlnstrk.transit.client.hci.method.subscruserdelete

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrUserDeleteServiceRequest(
  public var userId: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrUserDeleteServiceRequest.() -> Unit):
        HciSubscrUserDeleteServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscruserdelete.HciSubscrUserDeleteServiceRequest().apply(init)
  }
}
