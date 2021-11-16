package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGuiElement(
    public val caption: String?,
    public val defOptX: Int?,
    public val icoX: Int?,
    public val id: String?,
    public val optL: List<Option> = emptyList(),
    public val subElmL: List<Int> = emptyList(),
    public val text: String?,
    public val type: Type,
) {

    @HciModel("1.39")
    @Serializable
    public data class Action(
        public val tarElmState: State?,
        public val tarElmX: Int,
        public val tarOptX: Int?,
    )

    @HciModel("1.39")
    @Serializable
    public data class Option(
        public val actL: List<Action> = emptyList(),
        public val icoX: Int?,
        public val text: String?,
        public val value: String?,
    )

    @HciModel("1.39")
    @Serializable
    public enum class State {
        // TODO: Meaning?
        A,

        // TODO: Meaning?
        H,

        // TODO: Meaning?
        I
    }

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        CBOX,
        INPUT,
        LIST,
        PAGE,
        RAD,
        SBOX,
        TAB,
        TEXT
    }
}