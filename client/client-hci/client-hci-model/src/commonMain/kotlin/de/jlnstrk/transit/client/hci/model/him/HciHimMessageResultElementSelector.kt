package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciHimMessageResultElementSelector {
  ALL,
  BASIC,
  BASIC_WITH_MOD_TIMESTAMP,
}
