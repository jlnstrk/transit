package de.jlnstrk.transit.client.hci.method.feedbackstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.feedback.HciFeedback
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFeedbackStoreServiceRequest(
  public var feedback: HciFeedback? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciFeedbackStoreServiceRequest.() -> Unit):
        HciFeedbackStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.feedbackstore.HciFeedbackStoreServiceRequest().apply(init)
  }
}
