package de.jlnstrk.transit.client.hci.method.feedbackmail

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFeedbackMailServiceRequest(
  public var captchaToken: String? = null,
  public var mailText: String? = null,
  public var sendAddr: String? = null,
  public var sendName: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciFeedbackMailServiceRequest.() -> Unit):
        HciFeedbackMailServiceRequest =
        de.jlnstrk.transit.client.hci.method.feedbackmail.HciFeedbackMailServiceRequest().apply(init)
  }
}
