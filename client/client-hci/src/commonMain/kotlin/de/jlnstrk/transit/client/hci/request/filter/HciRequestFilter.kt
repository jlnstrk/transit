package de.jlnstrk.transit.client.hci.request.filter

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciRequestFilterMode {
    BIT,
    INC,
    EXC,
    UNDEF
}