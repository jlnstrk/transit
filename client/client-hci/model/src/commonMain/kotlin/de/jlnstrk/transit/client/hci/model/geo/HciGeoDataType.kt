package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciGeoDataType {
  @SerialName("GeoJSON")
  GEO_JSON,
}
