package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoFeatureTypeSelection(
  public val subType: String? = null,
  public val type: HciGeoFeatureType? = null,
)
