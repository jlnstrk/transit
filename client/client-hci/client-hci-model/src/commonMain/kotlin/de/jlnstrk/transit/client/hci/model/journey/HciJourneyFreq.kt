package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyFreq(
  public val jnyL: List<HciJourney> = emptyList(),
  public val maxC: Int = -1,
  public val minC: Int = -1,
  public val numC: Int = -1,
)
