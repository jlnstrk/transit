package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciConnectionReliabilityType {
  ABORTIVE,
  GUARANTEED,
  HIGH,
  LOW,
  UNDEF,
}
