package de.jlnstrk.transit.common.model

import kotlinx.serialization.Serializable

@Serializable
public data class Coordinates(
    /** The WGS84 latitude coordinate */
    public val latitude: Double,
    /** The WGS84 longitude coordinate */
    public val longitude: Double,
    /** The altitude in meters */
    public val altitude: Double? = null
)