package de.jlnstrk.transit.client.hci.method.geofeaturegeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoFeatureTypeSelection
import de.jlnstrk.transit.client.hci.model.geo.HciGeoFeatureValiditySelection
import de.jlnstrk.transit.client.hci.model.geo.HciGeoSelection
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoFeatureGeoPosServiceRequest(
  public var geoSelect: HciGeoSelection? = null,
  public var maxResults: Int? = null,
  public var provider: String? = null,
  public var query: String? = null,
  public var typeSelect: HciGeoFeatureTypeSelection? = null,
  public var validity: HciGeoFeatureValiditySelection? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciGeoFeatureGeoPosServiceRequest.() -> Unit):
        HciGeoFeatureGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.geofeaturegeopos.HciGeoFeatureGeoPosServiceRequest().apply(init)
  }
}
