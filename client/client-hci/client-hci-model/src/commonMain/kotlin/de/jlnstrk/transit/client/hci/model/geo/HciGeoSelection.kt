package de.jlnstrk.transit.client.hci.model.geo

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGeoSelection(
  public val rect: HciGeoRect? = null,
  public val ring: HciGeoRing? = null
)
