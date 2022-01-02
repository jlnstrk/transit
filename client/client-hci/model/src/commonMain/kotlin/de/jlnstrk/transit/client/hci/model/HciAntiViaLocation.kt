package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciAntiViaLocation(
  public val loc: HciLocation,
  public val stat: HciAntiViaStatus = HciAntiViaStatus.NCAVM
)
