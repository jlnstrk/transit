package de.jlnstrk.transit.client.hci.method.geofeaturedetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoFeatureDetailsServiceRequest(
  public var id: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciGeoFeatureDetailsServiceRequest.() -> Unit):
        HciGeoFeatureDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.geofeaturedetails.HciGeoFeatureDetailsServiceRequest().apply(init)
  }
}
