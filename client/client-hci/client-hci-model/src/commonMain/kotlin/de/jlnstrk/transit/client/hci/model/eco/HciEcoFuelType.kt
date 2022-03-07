package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciEcoFuelType {
  @SerialName("avg")
  AVG,
  @SerialName("diesel")
  DIESEL,
  @SerialName("electric")
  ELECTRIC,
  @SerialName("gas")
  GAS,
  @SerialName("hybrid")
  HYBRID,
  @SerialName("lpg")
  LPG,
  @SerialName("plugin")
  PLUGIN,
}
