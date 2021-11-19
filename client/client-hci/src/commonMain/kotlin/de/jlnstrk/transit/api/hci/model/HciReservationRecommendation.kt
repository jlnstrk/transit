package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciReservationRecommendation {
    // TODO: Meaning?
    B,

    // TODO: Meaning?
    F,

    // TODO: Meaning?
    N,

    // TODO: Meaning?
    S,

    // TODO: Meaning?
    U
}