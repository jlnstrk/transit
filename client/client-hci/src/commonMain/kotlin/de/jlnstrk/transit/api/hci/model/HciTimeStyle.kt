package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciTimeStyle(
    public val mode: Mode,
    public val fg: HciColor?,
    public val icoX: Int?,

    public val strikeOut: Boolean?,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Mode {
        @SerialName("ABS")
        ABSOLUTE,

        @SerialName("DLT")
        DELTA,

        @SerialName("CNT")
        COUNT,

        HIDE,
    }
}