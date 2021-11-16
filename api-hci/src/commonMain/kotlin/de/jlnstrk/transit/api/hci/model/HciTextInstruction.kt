package de.jlnstrk.transit.api.hci.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciTextInstruction(
    public val id: String,
    public val mode: Mode,
    public val type: Type,
    public val locX: Int?,
    public val urlX: Int?,
) {

    @Serializable
    public data class Interval(
        public val startIndex: Int,
        public val endIndex: Int,
        public val textInstructionX: Int
    )

    @Serializable
    public enum class Mode {
        ADD,

        @SerialName("ADD_AFT")
        ADD_AFTER,

        @SerialName("ADD_BRF")
        ADD_BEFORE,

        @SerialName("RPLC")
        REPLACE,
    }

    @Serializable
    public enum class Type {
        BOLD,
        CALL,
        COLOR,
        ICON,
        ITALIC,
        LINK,
        NONE,

        @SerialName("PROD")
        PRODUCT,
        WEBVIEW
    }
}