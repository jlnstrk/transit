package de.jlnstrk.transit.client.hci.method.subscrsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrSearchServiceRequest(
  public var onlySubIds: Boolean? = null,
  public var userId: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrSearchServiceRequest.() -> Unit):
        HciSubscrSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrsearch.HciSubscrSearchServiceRequest().apply(init)
  }
}
