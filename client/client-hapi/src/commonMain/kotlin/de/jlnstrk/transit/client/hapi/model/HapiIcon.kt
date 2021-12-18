package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiIcon.Shape
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiIcon(
    /** Text color */
    public val foregroundColor: HapiColor?,
    /** Background color */
    public val backgroundColor: HapiColor?,
    /** Border color */
    public val borderColor: HapiColor?,
    /** Resource description or name */
    public val res: String,
    /** Text */
    public val txt: String?,
    /** Short text */
    public val txtS: String?,
    /** Text style */
    public val style: Style? = null,
    /** Icon shape */
    public val shape: Shape? = null,
    /** Shape description. Only relevant if [shape] equals [Shape.RES] */
    public val shapeRes: String?,
) {

    @HapiXsd("1.29")
    @Serializable
    public enum class Style {
        @SerialName("U")
        UNKNOWN,

        @SerialName("B")
        BOLD,

        @SerialName("I")
        ITALIC,

        @SerialName("BI")
        BOLD_ITALIC,
    }

    @HapiXsd("1.29")
    @Serializable
    public enum class Shape {
        @SerialName("U")
        UNKNOWN,

        @SerialName("R")
        RECTANGLE,

        @SerialName("C")
        CIRCLE,

        /** Use shape described in [shapeRes] */
        RES,
    }
}