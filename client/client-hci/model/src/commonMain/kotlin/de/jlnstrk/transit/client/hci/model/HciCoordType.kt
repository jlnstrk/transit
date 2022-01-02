package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciCoordType {
  FLAT,
  HAFASGEO,
  PLANAR,
  @SerialName("WGS84")
  WGS_84,
}
