package de.jlnstrk.transit.client.hci.method.userlogin

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciUserLoginServiceRequest(
  public var uName: String? = null,
  public var uPass: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciUserLoginServiceRequest.() -> Unit):
        HciUserLoginServiceRequest =
        de.jlnstrk.transit.client.hci.method.userlogin.HciUserLoginServiceRequest().apply(init)
  }
}
