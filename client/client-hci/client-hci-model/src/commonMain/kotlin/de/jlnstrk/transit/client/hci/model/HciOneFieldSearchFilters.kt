package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocationFilter
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciOneFieldSearchFilters(
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val locFltrL: List<HciLocationFilter> = emptyList()
)
