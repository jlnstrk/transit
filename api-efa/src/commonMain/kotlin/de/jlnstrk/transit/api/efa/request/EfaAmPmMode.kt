package de.jlnstrk.transit.api.efa.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EfaAmPmMode {
    @SerialName("am")
    AM,

    @SerialName("pm")
    PM,
}