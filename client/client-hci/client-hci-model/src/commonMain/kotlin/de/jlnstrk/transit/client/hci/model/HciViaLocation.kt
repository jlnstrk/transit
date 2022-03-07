package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciViaLocation(
  public val loc: HciLocation,
  public val min: Int = 0,
  public val stat: HciViaStatus = HciViaStatus.EXR
)
