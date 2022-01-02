package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackMatchQuality(
  public val activityMatch: Int? = null,
  public val avgGraphDistance: Int? = null,
  public val avgGraphTimeDistance: Int? = null,
  public val checkInQuality: Int? = null,
  public val checkOutQuality: Int? = null,
  public val maxGraphDistance: Int? = null,
  public val overallRating: Int? = null,
  public val percentCoverage: Int? = null,
  public val percentRealtime: Int? = null,
  public val percentTrackCoverage: Int? = null,
  public val spatialMatch: Int? = null,
  public val spatialStationBeaconMatch: Int? = null,
  public val timeSpatialMatch: Int? = null,
  public val vehicleBeaconMatch: Int? = null
)
