package de.jlnstrk.transit.api.hci.model.message

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciMessageDisplay {
    COL,
    EXP,
    HIDE,

    // TODO: Meaning?
    U,
}