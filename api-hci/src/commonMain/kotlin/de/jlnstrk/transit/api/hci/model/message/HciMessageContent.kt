package de.jlnstrk.transit.api.hci.model.message

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciMessageContent {
    EMAIL,

    // TODO: Meaning?
    I,
    SMS,

    // TODO: Meaning?
    T,
    TEL,

    // TODO: Meaning?
    U,
    UNDEF
}