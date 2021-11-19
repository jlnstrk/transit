package de.jlnstrk.transit.api.hci.model.eco

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciEcoFlightFeeder {
    @SerialName("both")
    BOTH,

    @SerialName("car")
    CAR,

    @SerialName("train")
    TRAIN,
}