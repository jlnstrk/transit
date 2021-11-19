package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of detailed journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyDetailList(
    public val JourneyDetail: List<HapiJourneyDetail> = emptyList(),
) : HapiResponse()