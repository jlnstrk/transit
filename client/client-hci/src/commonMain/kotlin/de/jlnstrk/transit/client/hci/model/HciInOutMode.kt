package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciInOutMode {
    // TODO: => Both?
    @SerialName("B")
    B,

    @SerialName("I")
    IN,

    // TODO: => Neither?
    @SerialName("N")
    N,

    @SerialName("O")
    OUT,
}