package de.jlnstrk.transit.client.hci.method.sharetrip

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.share.HciShareMail
import de.jlnstrk.transit.client.hci.model.share.HciShareMode
import de.jlnstrk.transit.client.hci.model.share.HciShareSMS
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciShareTripServiceRequest(
  public var captchaToken: String? = null,
  public var ctxRecon: String? = null,
  public var mail: HciShareMail? = null,
  public var mode: HciShareMode? = null,
  public var sms: HciShareSMS? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciShareTripServiceRequest.() -> Unit):
        HciShareTripServiceRequest =
        de.jlnstrk.transit.client.hci.method.sharetrip.HciShareTripServiceRequest().apply(init)
  }
}
