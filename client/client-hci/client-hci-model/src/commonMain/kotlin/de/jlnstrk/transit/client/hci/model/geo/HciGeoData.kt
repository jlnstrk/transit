package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoData(
  public val `data`: String,
  public val id: String? = null,
  public val maxZoom: Int? = null,
  public val minZoom: Int? = null,
  public val type: HciGeoDataType,
)
