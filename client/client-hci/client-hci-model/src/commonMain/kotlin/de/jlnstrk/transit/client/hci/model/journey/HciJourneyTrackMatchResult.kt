package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciNamedValue
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackMatchResult(
  public val algorithm: HciJourneyTrackMatchAlgorithm? = null,
  public val diagnostics: List<HciNamedValue> = emptyList(),
  public val jnyL: List<HciJourneyTrackMatchJourney> = emptyList(),
  public val matchDeviation: Int? = null,
  public val matchQuality: HciJourneyTrackMatchQuality? = null,
)
