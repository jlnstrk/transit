package de.jlnstrk.transit.client.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@HapiXsd("1.29")
@Serializable
public enum class HafasGisOrientation {
    @SerialName("U")
    UNKNOWN,

    @SerialName("NW")
    NORTH_WEST,

    @SerialName("N")
    NORTH,

    @SerialName("NE")
    NORTH_EAST,

    @SerialName("E")
    EAST,

    @SerialName("SE")
    SOUTH_EAST,

    @SerialName("S")
    SOUTH,

    @SerialName("SW")
    SOUTH_WEST,

    @SerialName("W")
    WEST,
}