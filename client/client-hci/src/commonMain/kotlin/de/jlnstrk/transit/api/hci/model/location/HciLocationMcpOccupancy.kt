package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciLocationMcpOccupancy {
    // TODO: Meaning?
    A,

    // TODO: Meaning?
    E,

    // TODO: Meaning?
    N,

    // TODO: Meaning?
    U
}