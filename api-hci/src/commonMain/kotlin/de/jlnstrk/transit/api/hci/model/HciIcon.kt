package de.jlnstrk.transit.api.hci.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciIcon(
    /** The name of resource associated with this icon */
    public val res: String?,

    /** The foreground color to be applied to this icon */
    public val fg: HciColor?,

    /** The background color to be applied to this icon */
    public val bg: HciColor?,

    /** The border color to be applied to this icon */
    public val brd: HciColor?,

    /** The shape to be used to draw this icon */
    public val shp: Shape?,

    /** The name of the resource if [shape] is [Shape.RESOURCE] */
    public val shpRes: String?,

    /** The text to be displayed with this icon */
    public val txt: String?,

    public val txtA: String?,
) {

    @Serializable
    public enum class Style {
        // Underlined?
        @SerialName("U")
        UNKNOWN,

        @SerialName("N")
        NORMAL,

        @SerialName("B")
        BOLD,

        @SerialName("I")
        ITALIC,

        @SerialName("BI")
        BOLD_ITALIC
    }

    @Serializable
    public enum class Shape {
        // Pretty sure this is unknown
        @SerialName("U")
        UNKNOWN,

        @SerialName("R")
        RECTANGLE,

        @SerialName("C")
        CIRCLE,

        @SerialName("RES")
        RESOURCE
    }
}