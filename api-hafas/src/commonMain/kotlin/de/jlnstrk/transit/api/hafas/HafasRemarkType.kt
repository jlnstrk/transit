package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@HapiXsd("1.29")
@Serializable
public enum class HafasRemarkType {
    @SerialName("A")
    ATTRIBUTE,

    @SerialName("B")
    THROUGH_CONNECTION,

    @SerialName("C")
    CONNECTION,

    @SerialName("D")
    DELAY,

    @SerialName("ED")
    EU_DELFI,

    // TODO: Meaning?
    @SerialName("FN")
    FN,

    @SerialName("G")
    PLATFORM_CHANGE,

    @SerialName("H")
    HINT,

    @SerialName("I")
    INFOTEXT,

    @SerialName("K")
    ENTRY_XI_INFOTEXT,

    @SerialName("L")
    REFERENCE_TRAIN,

    @SerialName("M")
    HIM_MESSAGE,

    @SerialName("N")
    REALTIME_CONNECTION,

    @SerialName("O")
    REALTIME_STOP,

    @SerialName("P")
    CANCELLATION,

    @SerialName("Q")
    FREETEXT,

    @SerialName("R")
    REALTIME,

    @SerialName("S")
    TRAIN_CHANGE,

    @SerialName("TAR")
    TARIFF,

    @SerialName("U")
    UNKNOWN,

    @SerialName("V")
    PRODUCT_CHANGE,

    @SerialName("W")
    WEBVIEW,

    @SerialName("X")
    PLATFORM_CHANGE_EXTENDED,

    @SerialName("Y")
    DEVIATION,

    @SerialName("Z")
    ITINERARY,
}