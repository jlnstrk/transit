package de.jlnstrk.transit.api.hci.model.connection

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciConnectionScoring(
    /** The type of this scoring */
    public val type: Type,

    /** The name of this scoring */
    public val name: String?,

    /** The list of connections' scores in this scoring */
    public val conScoreL: List<Score> = emptyList(),

    /** The icon associated with this scoring */
    public val icoX: Int?,
) {

    @HciModel("1.39")
    @Serializable
    public data class Score(
        /** The numerical value of this score */
        public val score: Long,

        /** The string value of this score */
        public val scoreS: String?,

        /** The indices of connections with this score in [HciTripSearchResponse.outConL] */
        public val conRefL: List<Int> = emptyList(),
    )

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        @SerialName("DT")
        DEPARTURE,

        @SerialName("AT")
        ARRIVAL,

        @SerialName("TI")
        DURATION,

        // TODO: Meaning?
        CF,

        // TODO: Meaning? Do they actually mean carbon oxide?
        CO,

        CO_2,

        // TODO: Meaning?
        PT,

        // TODO: Meaning?
        UT,
    }
}