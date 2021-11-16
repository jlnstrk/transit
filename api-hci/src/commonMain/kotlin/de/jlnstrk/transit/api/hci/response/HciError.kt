package de.jlnstrk.transit.api.hci.response

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciError {
    /** Invalid or missing authentication data */
    AUTH,
    CLIENTVERSION,
    ERROR,
    HAMM,
    HAMM_LOAD,
    MEMORY,
    NULLPTR,
    OK,
    PARSE,
    VERSION,
    WRITE,

    // TODO: HciError or HciServiceError?
    VD,
}