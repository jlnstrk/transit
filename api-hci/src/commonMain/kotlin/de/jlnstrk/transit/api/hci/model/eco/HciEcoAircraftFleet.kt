package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciEcoAircraftFleet {
    @SerialName("avg")
    AVG,

    @SerialName("modern")
    MODERN,
}