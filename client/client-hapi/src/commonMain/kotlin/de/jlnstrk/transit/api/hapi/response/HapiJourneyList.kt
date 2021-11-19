package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyList(
    public val Journey: List<HapiJourney> = emptyList(),
) : HapiResponse()