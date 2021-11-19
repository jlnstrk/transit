package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiJourneyDetailGroup
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of grouped detailed journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyDetailGroupList(
    public val JourneyDetailGroup: List<HapiJourneyDetailGroup> = emptyList(),
) : HapiResponse()