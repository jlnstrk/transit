package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciConnectionScoringType {
  AT,
  CF,
  CO,
  @SerialName("CO2")
  CO_2,
  DT,
  OC,
  PT,
  TI,
  UT,
}
