package de.jlnstrk.transit.api.hci.model.message

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciMessageStyle {
    // TODO: Meaning?
    C,

    // TODO: Meaning?
    I,

    // TODO: Meaning?
    M,

    // TODO: Meaning?
    U,
}