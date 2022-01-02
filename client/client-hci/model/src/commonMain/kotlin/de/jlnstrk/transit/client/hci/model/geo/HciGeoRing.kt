package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoRing(
  public val cCrd: HciCoord,
  public val maxDist: Int,
  public val minDist: Int = 0
)
