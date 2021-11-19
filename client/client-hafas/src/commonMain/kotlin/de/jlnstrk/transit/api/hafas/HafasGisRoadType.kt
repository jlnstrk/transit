package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@HapiXsd("1.29")
@Serializable
public enum class HafasGisRoadType {
    @SerialName("U")
    UNKNOWN,

    @SerialName("M")
    MOTORWAY,

    @SerialName("H")
    HIGHWAY,

    @SerialName("T")
    TRUNK_ROAD,

    @SerialName("T4L")
    TRUNK_ROAD_FOUR_LANES,

    @SerialName("T2L")
    TRUNK_ROAD_TWO_LANES,

    @SerialName("TR")
    COUNTRY_ROAD,

    @SerialName("NT")
    COUNTY_ROAD,

    @SerialName("CT")
    CITY_ROAD,

    @SerialName("R")
    RESIDENTIAL_ROAD,

    @SerialName("B")
    BLOCKED_ROAD,

    @SerialName("CW")
    COMBINED_CYCLE_WALKWAY,

    @SerialName("C")
    CYCLEWAY,

    @SerialName("W")
    WALKWAY,

    @SerialName("F")
    FERRY,
}