package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyList(
    public val Journey: List<HapiJourney> = emptyList(),
) : HapiResponse()