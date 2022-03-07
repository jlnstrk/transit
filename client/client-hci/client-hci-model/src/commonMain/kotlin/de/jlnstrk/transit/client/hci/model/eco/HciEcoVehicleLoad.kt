package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciEcoVehicleLoad {
  @SerialName("1")
  _1,
  _2,
  _3,
  @SerialName("4")
  _4,
  @SerialName("5")
  _5,
  @SerialName("avg")
  AVG,
}
