package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyStatistics(
  public val cncl: Int = -1,
  public val dly1: Int = -1,
  public val dly2: Int = -1,
  public val ont: Int = -1
)
