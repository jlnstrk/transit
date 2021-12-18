package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciPlanDataEncoding {
    @SerialName("ISO-8859-1")
    ISO_8859_1,

    @SerialName("ISO-8859-15")
    ISO_8859_15,

    @SerialName("ISO-8859-2")
    ISO_8859_2,

    @SerialName("ISO-8859-5")
    ISO_8859_5,

    @SerialName("ISO-8859-9")
    ISO_8859_9,

    @SerialName("UNKNOWN")
    UNKNOWN,

    @SerialName("UTF-16")
    UTF_16,

    @SerialName("UTF-32")
    UTF_32,

    @SerialName("UTF-8")
    UTF_8,
}