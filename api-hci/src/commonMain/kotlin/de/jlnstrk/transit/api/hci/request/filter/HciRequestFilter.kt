package de.jlnstrk.transit.api.hci.request.filter

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciRequestFilterMode {
    BIT,
    INC,
    EXC,
    UNDEF
}