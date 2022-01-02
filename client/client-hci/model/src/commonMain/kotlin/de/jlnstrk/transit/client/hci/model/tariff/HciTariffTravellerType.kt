package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciTariffTravellerType {
  ADULT,
  BIKE,
  CHILD,
  DISABLED,
  GROUP,
  SENIOR,
  YOUTH,
}
