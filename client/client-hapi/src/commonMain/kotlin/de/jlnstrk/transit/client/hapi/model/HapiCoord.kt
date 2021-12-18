package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiCoord(
    public val lon: Double,
    public val lat: Double,
    public val alt: Double?,
) {

    @HapiXsd("1.29")
    @Serializable
    public enum class Type {
        WGS84,
        PLANAR,
        HAFASGEO,
    }
}