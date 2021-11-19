package de.jlnstrk.transit.api.hci.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HciDirection(
    /** The id of this direction */
    public val did: String?,

    /** The flag associated with this direction */
    public val flg: String?,

    /** The geometric value of this direction. Range 0..31 */
    public val geo: Int = -1,

    /** The key of this direction */
    public val key: String?,

    /** The textual description of this direction */
    public val txt: String,

    /** The location this direction points to */
    public val locX: Int?,

    /** The journeys associated with this direction */
    public val jnyRefL: List<Int> = emptyList(),

    /** The locations associated with this direction */
    public val locRefL: List<Int> = emptyList(),

    /** The products associated with this direction */
    public val pRefL: List<Int> = emptyList(),
) {

    @Serializable
    public enum class Type {
        @SerialName("F")
        FORWARD,

        @SerialName("B")
        BACKWARD,

        @SerialName("FB")
        FORWARD_BACKWARD,
    }
}