package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisPreferredLocation(
  public val dLoc: HciLocation? = null,
  public val sLoc: HciLocation? = null,
  public val type: HciGisType,
)
