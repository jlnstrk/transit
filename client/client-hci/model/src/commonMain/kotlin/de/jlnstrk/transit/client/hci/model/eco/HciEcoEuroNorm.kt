package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciEcoEuroNorm {
  @SerialName("avg")
  AVG,
  @SerialName("euro3")
  EURO_3,
  @SerialName("euro4")
  EURO_4,
  @SerialName("euro5")
  EURO_5,
  @SerialName("euro6")
  EURO_6,
}
