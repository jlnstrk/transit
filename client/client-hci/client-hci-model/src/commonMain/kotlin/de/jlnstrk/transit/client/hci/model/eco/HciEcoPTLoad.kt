package de.jlnstrk.transit.client.hci.model.eco

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciEcoPTLoad {
  @SerialName("avg")
  AVG,
  FULL,
}