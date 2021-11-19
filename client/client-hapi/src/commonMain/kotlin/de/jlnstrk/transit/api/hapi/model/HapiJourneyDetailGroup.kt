package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.response.HapiJourneyDetail
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