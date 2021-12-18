package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiJourneyDetailGroup
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of grouped detailed journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyDetailGroupList(
    public val JourneyDetailGroup: List<HapiJourneyDetailGroup> = emptyList(),
) : HapiResponse()