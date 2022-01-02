package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciFareTokenMode {
  ADD,
  CHOICE,
  COST,
  GAIN,
  INFO,
  LOAD,
}
