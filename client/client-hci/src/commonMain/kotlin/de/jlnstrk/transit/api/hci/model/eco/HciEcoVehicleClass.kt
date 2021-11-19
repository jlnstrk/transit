package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciEcoVehicleClass {
    @SerialName("high")
    HIGH,

    @SerialName("high_1")
    HIGH_1,

    @SerialName("high_2")
    HIGH_2,

    @SerialName("high_3")
    HIGH_3,

    @SerialName("low")
    LOW,

    @SerialName("low_1")
    LOW_1,

    @SerialName("low_2")
    LOW_2,

    @SerialName("low_3")
    LOW_3,

    @SerialName("medium")
    MEDIUM,

    @SerialName("medium_1")
    MEDIUM_1,

    @SerialName("medium_2")
    MEDIUM_2,

    @SerialName("medium_3")
    MEDIUM_3,

    @SerialName("offroad_1")
    OFFROAD_1,

    @SerialName("offroad_2")
    OFFROAD_2,

    @SerialName("offroad_3")
    OFFROAD_3,

    @SerialName("small")
    SMALL,

    @SerialName("super")
    SUPER,

    @SerialName("van_1")
    VAN_1,

    @SerialName("van_2")
    VAN_2,

    @SerialName("van_3")
    VAN_3,
}