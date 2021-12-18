package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciJourneyMatchGroup(
    public val journeys: List<HciJourney> = emptyList(),
    public val name: String?,
    public val nameS: String?,
)