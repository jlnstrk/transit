package de.jlnstrk.transit.api.hci.model.journey

import kotlinx.serialization.Serializable

@Serializable
public data class HciJourneyDelaySummary(
    /** The name of this delay summary */
    public val name: String?,

    /** The cumulated delay of all journeys */
    public val cumulatedDelay: Int?,

    /** THe total number of trains on this journey */
    public val numTrains: Int?,

    /** The total number of punctual trains on this journey */
    public val numTrainsOnTime: Int?,
)