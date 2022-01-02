package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciHimMatchImpactType {
  AFFECTED_SECTION,
  END_OF_ROUTE,
  NONE,
}
