package de.jlnstrk.transit.api.hci

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciClient(
    public val id: String,
    public val type: Type,
    public val name: String,
    public val v: String? = null,
    public val l: String? = null,
    public val os: String? = null,
    public val res: String? = null,
    public val stats: String? = null,
    public val ua: String? = null,
    public val userId: String? = null,
) {

    @Serializable
    public enum class Type {
        @SerialName("IPA")
        IPAD,

        @SerialName("IPH")
        IPHONE,

        WEB,

        @SerialName("AND")
        ANDROID
    }
}