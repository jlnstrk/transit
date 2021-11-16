@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.response

import de.jlnstrk.transit.api.efa.serializer.EfaMessageSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable(with = EfaMessageSerializer::class)
public class EfaMessage(
    public val code: Code?,
    public val error: String?,
    public val type: Type?,
    public val module: Module
) {
    @Serializable
    public enum class Code {
        @SerialName("-303")
        NO_IT_CONNECTION,

        @SerialName("-10015")
        ITP,

        @SerialName("-8010")
        UNKNOWN,

        @SerialName("-8011")
        UNKNOWN_2
    }

    @Serializable
    public enum class Type {
        @SerialName("warning")
        WARNING
    }

    @Serializable
    public enum class Module {
        BROKER
    }
}