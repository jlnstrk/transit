package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.response.HapiJourneyDetail
import kotlinx.serialization.Serializable

/** A group of detailed journeys. */
@HapiXsd("1.29")
@Serializable
public data class HapiJourneyDetailGroup(
    public val JourneyDetail: List<HapiJourneyDetail> = emptyList(),
    /** Name of this group. */
    public val name: String?,
    /** Short name of this group. */
    public val nameS: String?,
)