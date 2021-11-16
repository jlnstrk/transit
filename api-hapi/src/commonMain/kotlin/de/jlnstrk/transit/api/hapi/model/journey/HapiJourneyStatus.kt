package de.jlnstrk.transit.api.hapi.model.journey

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Contains the status of the journey. */
@HapiXsd("1.29")
@Serializable
public enum class HapiJourneyStatus {
    /** Planned: A planned journey. This is also the default value. */
    @SerialName("P")
    PLANNED,

    /** Replacement: The journey was added as a replacement for a planned journey. */
    @SerialName("R")
    REPLACEMENT,

    /** Additional: The journey is an additional journey to the planned journeys. */
    @SerialName("A")
    ADDITIONAL,

    /** Special: This is a special journey.
     * The exact definition which journeys are considered special up to the customer. */
    @SerialName("S")
    SPECIAL,
}