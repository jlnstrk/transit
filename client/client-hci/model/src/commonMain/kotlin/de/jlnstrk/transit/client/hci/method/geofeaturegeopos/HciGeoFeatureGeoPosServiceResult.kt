package de.jlnstrk.transit.client.hci.method.geofeaturegeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.geo.HciGeoFeature
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciGeoFeatureGeoPosServiceResult(
  public val common: HciCommon? = null,
  public val geoFeatures: List<HciGeoFeature> = emptyList()
) : HciServiceResult()
