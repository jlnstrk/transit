package de.jlnstrk.transit.api.hci.model

import kotlinx.serialization.Serializable

@Serializable
public data class HciDrawableLineStyle(
    /** The type of this line style */
    public val type: Type,
    /** The background color of this line style */
    public val bg: HciColor?,
    /** The border color of this line style */
    public val brd: HciColor?,
    /** The start icon of this line style */
    public val sIcoX: Int?,
    /** The end icon of this line style */
    public val eIcoX: Int?,
) {

    @Serializable
    public enum class Type {
        DASH,
        DOT,
        GAP,
        SOLID
    }
}