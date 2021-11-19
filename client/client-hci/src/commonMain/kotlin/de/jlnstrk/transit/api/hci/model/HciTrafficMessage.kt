package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciTrafficMessage(
    public val tmid: Int?,
    public val type: Type?,
    public val name: String?,
    public val desc: String?,
    public val extId: String?,
    public val icoX: Int?,
    public val locX: Int?,
    public val polyG: HciPolylineGroup?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        // TODO: Meaning?
        AC,
        ACCIDENT,

        // TODO: Meaning?
        AT,
        BURNING_VEHICLE,

        // TODO: Meaning?
        CO,
        CONSTRUCTION_SITE,
        DANGER,
        DELAY,
        JUNCTION_CLOSED,
        LANE_CLOSED,
        OBSTRUCTION,
        RAIL_ROAD_CROSSING,

        // TODO: Meaning?
        RCLM,
        ROAD_CLOSED,

        // TODO Meaning? roadworks?
        RW,
        TRAFFIC_JAM,
        TRAFFIC_LIGHTS_DEFECT,

        @SerialName("U")
        UNKNOWN,
        WEATHER,
        WEATHER_HAIL,
        WEATHER_ICE,
        WEATHER_POOR_VISIBILITY,
        WEATHER_SNOW,
        WEATHER_WIND
    }
}