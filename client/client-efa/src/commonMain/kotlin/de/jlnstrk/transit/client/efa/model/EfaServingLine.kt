@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaServingLine(
    public val key: Long,
    public val code: EfaMeansOfTransport,
    public val number: String?,
    public val symbol: String?,
    public val motType: EfaMeansOfTransport,
    public val mtSubcode: Int?,
    public val realtime: Boolean,
    public val direction: String,
    public val directionFrom: String,
    public val trainNum: String?,
    public val name: String,
    @Serializable(with = EfaMinutesSerializer::class)
    public val delay: Duration?,
    public val hints: List<EfaHint>?,
    public val liErgRiProj: ErgRiProject,
    public val destID: Long,
    public val stateless: String,
    public val lineDisplay: LineDisplay? = null,
) {

    @Serializable
    public data class ErgRiProject(
        public val line: String,
        public val project: String,
        public val direction: String,
        public val supplement: String?,
        public val network: String
    )

    @Serializable
    public enum class LineDisplay {
        @SerialName("line")
        LINE
    }
}