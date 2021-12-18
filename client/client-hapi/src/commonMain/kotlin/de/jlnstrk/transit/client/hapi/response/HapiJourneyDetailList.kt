package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** A list of detailed journeys. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyDetailList(
    public val JourneyDetail: List<HapiJourneyDetail> = emptyList(),
) : HapiResponse()