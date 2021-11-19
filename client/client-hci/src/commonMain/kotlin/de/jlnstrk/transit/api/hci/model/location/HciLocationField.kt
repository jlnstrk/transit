package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciLocationField {
    // TODO: Meaning?
    D,
    // TODO: Meaning?
    S,
    // TODO: Meaning?
    V,
}