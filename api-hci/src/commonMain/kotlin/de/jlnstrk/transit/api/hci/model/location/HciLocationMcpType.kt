package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciLocationMcpType {
    // TODO: Meaning?
    A,

    // TODO: Meaning?
    P,

    // TODO: Meaning?
    U,

    // TODO: Meaning?
    V
}