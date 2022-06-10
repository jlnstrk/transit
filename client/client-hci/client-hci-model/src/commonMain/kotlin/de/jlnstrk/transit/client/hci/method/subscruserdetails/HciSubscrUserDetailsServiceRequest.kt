package de.jlnstrk.transit.client.hci.method.subscruserdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrUserDetailsServiceRequest(
  public var userId: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrUserDetailsServiceRequest.() -> Unit):
        HciSubscrUserDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscruserdetails.HciSubscrUserDetailsServiceRequest().apply(init)
  }
}
