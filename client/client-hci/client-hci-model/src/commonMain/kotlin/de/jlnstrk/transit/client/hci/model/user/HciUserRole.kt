package de.jlnstrk.transit.client.hci.model.user

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciUserRole {
  DR,
  SE,
  ST,
  TR,
  U,
}
