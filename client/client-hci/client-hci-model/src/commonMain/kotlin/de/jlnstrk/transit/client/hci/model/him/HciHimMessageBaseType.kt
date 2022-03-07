package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciHimMessageBaseType {
  GLOBAL,
  INFRASTRUCTURE,
  UNDEF,
}