package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyMatchGroup(
  public val journeys: List<HciJourney> = emptyList(),
  public val name: String? = null,
  public val nameS: String? = null,
)
