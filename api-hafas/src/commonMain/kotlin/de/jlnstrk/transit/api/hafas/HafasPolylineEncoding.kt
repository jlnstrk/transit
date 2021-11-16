package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HafasPolylineEncoding {
    @SerialName("GPA")
    GOOGLE,

    @SerialName("DLT")
    DELTA,

    @SerialName("N")
    NONE
}