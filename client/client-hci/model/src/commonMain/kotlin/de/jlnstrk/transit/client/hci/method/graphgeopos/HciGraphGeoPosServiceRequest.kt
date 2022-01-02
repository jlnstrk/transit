package de.jlnstrk.transit.client.hci.method.graphgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import kotlin.Boolean
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGraphGeoPosServiceRequest(
  public var getAffPoly: Boolean? = null,
  public var ring: HciGeoRing? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciGraphGeoPosServiceRequest.() -> Unit):
        HciGraphGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.graphgeopos.HciGraphGeoPosServiceRequest().apply(init)
  }
}
