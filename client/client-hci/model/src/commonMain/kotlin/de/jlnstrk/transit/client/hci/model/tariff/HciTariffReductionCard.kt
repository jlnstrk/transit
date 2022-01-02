package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciTariffReductionCard {
  ABO_FLEX,
  @SerialName("BC25")
  BC_25,
  @SerialName("BC25F")
  BC_25_F,
  @SerialName("BC50")
  BC_50,
  @SerialName("BC50F")
  BC_50_F,
  HALBTAX,
  NONE,
  SHCARD,
}
