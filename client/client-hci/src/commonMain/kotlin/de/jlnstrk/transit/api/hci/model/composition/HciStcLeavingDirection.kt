package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciStcLeavingDirection {
    @SerialName("L")
    LEFT,

    @SerialName("N")
    NONE,

    @SerialName("R")
    RIGHT,
}