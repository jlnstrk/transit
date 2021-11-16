package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Occupancy information */
@HapiXsd("1.29")
@Serializable
public data class HapiOccupancy(
    /** Name of seat class or category. */
    public val name: String?,
    /** Seat occupancy value of this class or category between 0 and 100. */
    public val v: Int = 0,
    /** Public number of the car for which the occupancy data is valid for, if the data is only valid for a single car.
     * Otherwise this attribute is simply left out. */
    public val number: Int?,
    /** Seat occupancy raw data */
    public val raw: Int?,
)