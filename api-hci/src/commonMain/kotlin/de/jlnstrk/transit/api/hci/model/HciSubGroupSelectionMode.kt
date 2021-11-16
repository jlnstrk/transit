package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciSubGroupSelectionMode {
    @SerialName("M")
    MULTI,

    @SerialName("S")
    SINGLE,

    @SerialName("U")
    UNDEF,
}