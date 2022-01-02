package de.jlnstrk.transit.client.hci.model.message

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciMessageDisplayType {
  COL,
  EXP,
  HIDE,
  U,
}
