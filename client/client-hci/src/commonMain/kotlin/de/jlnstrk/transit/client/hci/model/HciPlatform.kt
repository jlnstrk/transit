package de.jlnstrk.transit.client.hci.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class HciPlatform(
    public val type: Type,
    public val txt: String,
) {

    @Serializable
    public enum class Type {
        @SerialName("CI")
        CI,

        @SerialName("CO")
        CO,

        @SerialName("FL")
        FL,

        @SerialName("GA")
        GA,

        @SerialName("H")
        H,

        @SerialName("PI")
        PI,

        @SerialName("PL")
        PL,

        @SerialName("SL")
        SL,

        @SerialName("ST")
        ST,

        @SerialName("U")
        U,

        @SerialName("X")
        X,
    }
}