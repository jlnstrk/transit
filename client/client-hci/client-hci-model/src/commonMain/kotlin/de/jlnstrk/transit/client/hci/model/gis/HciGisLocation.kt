package de.jlnstrk.transit.client.hci.model.gis

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciMCPPlaceType
import de.jlnstrk.transit.client.hci.model.HciTransportMode
import de.jlnstrk.transit.client.hci.model.HciUsageType
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisLocation(
  public val loc: HciLocation,
  public val locDurationOfStay: Int = 0,
  public val locMode: HciGisLocationMode,
  public val mode: HciGisFilterMode,
  public val placeType: HciMCPPlaceType? = null,
  public val transportMode: HciTransportMode,
  public val usageType: HciUsageType
)
