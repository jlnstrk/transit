package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoRect(
  public val llCrd: HciCoord,
  public val urCrd: HciCoord
)
