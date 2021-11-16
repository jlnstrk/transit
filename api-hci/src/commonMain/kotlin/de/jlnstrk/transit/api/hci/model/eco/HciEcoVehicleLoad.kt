package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciEcoVehicleLoad {
    @SerialName("1")
    ONE,

    @SerialName("2")
    TWO,

    @SerialName("3")
    THREE,

    @SerialName("4")
    FOUR,

    @SerialName("5")
    FIVE,

    @SerialName("avg")
    AVG,
}