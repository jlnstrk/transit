package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciMcpPlaceType {
    CHARGE,
    FIX,
    FLEX,
    FREE,
    RETURN,
    RIDE,
    UNDEF,
}