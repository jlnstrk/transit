package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciLocPreselectionStrategy {
  @SerialName("1_N_SELECTION")
  _1_N_SELECTION,
  N_1_SELECTION,
}
