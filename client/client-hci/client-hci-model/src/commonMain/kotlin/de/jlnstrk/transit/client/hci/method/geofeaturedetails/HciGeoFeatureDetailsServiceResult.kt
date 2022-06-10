package de.jlnstrk.transit.client.hci.method.geofeaturedetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.geo.HciGeoFeature
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciGeoFeatureDetailsServiceResult(
  public val common: HciCommon? = null,
  public val geoFeature: HciGeoFeature? = null,
) : HciServiceResult()
