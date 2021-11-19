package de.jlnstrk.transit.api.hci.model.message

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciMessageFormat {
    // TODO: Meaning?
    B,

    // TODO: Meaning?
    I,

    // TODO: Meaning?
    N,

    // TODO: Meaning?
    U,
}