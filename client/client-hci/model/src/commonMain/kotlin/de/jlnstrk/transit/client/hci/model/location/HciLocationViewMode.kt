package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciLocationViewMode {
  LI,
  LO,
  NI,
  PO,
  SB,
  SI,
  TI,
}
