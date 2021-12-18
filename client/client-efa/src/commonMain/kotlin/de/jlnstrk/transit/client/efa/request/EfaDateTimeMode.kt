package de.jlnstrk.transit.client.efa.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EfaDateTimeMode {
    @SerialName("dep")
    DEPARTURE,

    @SerialName("arr")
    ARRIVAL,

    @SerialName("firstService")
    FIRST_SERVICE,

    @SerialName("lastService")
    LAST_SERVICE,
}