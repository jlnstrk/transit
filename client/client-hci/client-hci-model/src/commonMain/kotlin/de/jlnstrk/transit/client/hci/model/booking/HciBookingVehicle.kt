package de.jlnstrk.transit.client.hci.model.booking

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.fare.HciFareNamedValue
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingVehicle(
  public val VCO: String? = null,
  public val VEN: String? = null,
  public val VEX: String? = null,
  public val VNV: List<HciFareNamedValue> = emptyList(),
)
