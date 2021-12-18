package de.jlnstrk.transit.client.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@HapiXsd("1.29")
@Serializable
public enum class HafasGisManeuver {
    @SerialName("NO")
    NOT_SET,

    @SerialName("FR")
    FROM,

    @SerialName("TO")
    TO,

    @SerialName("ON")
    ON,

    @SerialName("LE")
    LEFT,

    @SerialName("RI")
    RIGHT,

    @SerialName("KL")
    KEEP_LEFT,

    @SerialName("KR")
    KEEP_RIGHT,

    @SerialName("HL")
    HALF_LEFT,

    @SerialName("HR")
    HALF_RIGHT,

    @SerialName("KHL")
    KEEP_HALF_LEFT,

    @SerialName("KHR")
    KEEP_HALF_RIGHT,

    @SerialName("SL")
    SHARP_LEFT,

    @SerialName("SR")
    SHARP_RIGHT,

    @SerialName("KSL")
    KEEP_SHARP_LEFT,

    @SerialName("KSR")
    KEEP_SHARP_RIGHT,

    @SerialName("ST")
    STRAIGHT,

    @SerialName("UT")
    U_TURN,

    @SerialName("EN")
    ENTER,

    @SerialName("LV")
    LEAVE,

    @SerialName("ER")
    ENTER_ROUNDABOUT,

    @SerialName("SIR")
    STAY_IN_ROUNDABOUT,

    @SerialName("LR")
    LEAVE_ROUNDABOUT,

    @SerialName("EF")
    ENTER_FERRY,

    @SerialName("LF")
    LEAVE_FERRY,

    @SerialName("CH")
    CHANGE_HIGHWAY,

    @SerialName("CIF")
    CHECK_IN_FERRY,

    @SerialName("COF")
    CHECK_OUT_FERRY,

    @SerialName("EL")
    ELEVATOR,

    @SerialName("ELD")
    ELEVATOR_DOWN,

    @SerialName("ELU")
    ELEVATOR_UP,

    @SerialName("ES")
    ESCALATOR,

    @SerialName("ESD")
    ESCALATOR_DOWN,

    @SerialName("ESU")
    ESCALATOR_UP,

    @SerialName("STA")
    STAIRS,

    @SerialName("STD")
    STAIRS_DOWN,

    @SerialName("STU")
    STAIRS_UP,
}