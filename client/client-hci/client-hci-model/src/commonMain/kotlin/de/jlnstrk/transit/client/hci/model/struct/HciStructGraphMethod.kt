package de.jlnstrk.transit.client.hci.model.struct

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciStructGraphMethod {
  JOURNEY_COURSE,
}
