package de.jlnstrk.transit.api.hci.request.filter

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciRequestFilterMode {
    @SerialName("BIT")
    BITMASK,

    @SerialName("INC")
    INCLUSIVE,

    @SerialName("EXC")
    EXCLUSIVE,

    @SerialName("UNDEF")
    UNDEFINED
}