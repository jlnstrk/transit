package de.jlnstrk.transit.client.hci.method.checkintripstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciCheckInTripStoreServiceRequest(
  public var checkIn: Boolean? = null,
  public var reconCtx: String? = null,
  public var uId: String? = null,
  public var uPos: HciCoord? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciCheckInTripStoreServiceRequest.() -> Unit):
        HciCheckInTripStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.checkintripstore.HciCheckInTripStoreServiceRequest().apply(init)
  }
}
