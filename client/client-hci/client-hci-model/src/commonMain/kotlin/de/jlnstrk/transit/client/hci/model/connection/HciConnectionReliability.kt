package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionReliability(
  public val alternative: HciConnectionReliabilityType,
  public val original: HciConnectionReliabilityType,
)
