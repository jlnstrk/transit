@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaHint(
    /** The hint text */
    public val infoText: String?,

    /** The code of this hint */
    public val code: Code? = null,

    /** The url attached to this hint */
    public val url: String?,

    /** The subnet that this hint applies to */
    public val subnet: String?
) {

    @Serializable
    public enum class Code {
        FACE_MASK,
        BICYCLE_CARRIAGE,
        ACCESS_RAMP
    }
}