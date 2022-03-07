package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciJourneyMatchCombineMode {
  @SerialName("EXACT-LW")
  EXACT_LW,
  LW,
  @SerialName("LW-TIME")
  LW_TIME,
  NONE,
  @SerialName("VW-LW")
  VW_LW,
  @SerialName("VW-RI")
  VW_RI,
}
