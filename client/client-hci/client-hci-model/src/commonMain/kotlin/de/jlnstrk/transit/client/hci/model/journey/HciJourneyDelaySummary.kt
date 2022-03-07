package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyDelaySummary(
  public val name: String? = null,
  public val cumulatedDelay: Int = 0,
  public val numTrains: Int = 0,
  public val numTrainsOnTime: Int = 0
)
