package de.jlnstrk.transit.client.hci.method.subscrdelete

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrDeleteServiceRequest(
  public var subscrId: Int? = null,
  public var userId: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciSubscrDeleteServiceRequest.() -> Unit):
        HciSubscrDeleteServiceRequest =
        de.jlnstrk.transit.client.hci.method.subscrdelete.HciSubscrDeleteServiceRequest().apply(init)
  }
}
