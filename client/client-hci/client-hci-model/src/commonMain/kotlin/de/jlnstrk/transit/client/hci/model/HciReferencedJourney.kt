package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReferencedJourney(
  public val jny: HciJourney? = null,
  public val origFromIdx: Int? = null,
  public val origToIdx: Int? = null,
  public val refFromIdx: Int? = null,
  public val refToIdx: Int? = null,
  public val type: HciReferencedJourneyType,
)
