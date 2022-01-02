package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrResultCode {
  ERROR,
  INCOMP,
  OK,
}
