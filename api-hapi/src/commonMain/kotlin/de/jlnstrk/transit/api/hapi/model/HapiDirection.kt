package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Direction information. This is usually the last stop of the journey. */
@HapiXsd("1.29")
@Serializable
public data class HapiDirection(
    /** Defines the first stop/station where this type is valid. See the Stops list for details of the stop/station. */
    public val routeIdxFrom: Int = -1,
    /** Defines the last stop/station where this type is valid. See the Stops list for details of the stop/station. */
    public val routeIdxTo: Int = -1,
)