package de.jlnstrk.transit.api.hapi.model.trip

import de.jlnstrk.transit.api.hafas.HafasReliabilityType
import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiConnectionReliability(
    /** Reliability of the connection itself regarding its realtime status including cancellations,
     * delays etc. to the get to the destination in time. Used in time machine feature. */
    public val origin: HafasReliabilityType,
    /** Reliability of an alternative connection to the original connection regarding its realtime status
     * including cancellations, delays etc. Used in time machine feature. */
    public val alternative: HafasReliabilityType,
)