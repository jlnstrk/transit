@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.EfaInterchangeTypeAdapter
import de.jlnstrk.transit.client.efa.serializer.generic.EfaMapListSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaMode(
    /** The name of this mode of transport */
    public val name: String?,

    /** The number of this mode of transport */
    public val number: String?,

    /** The product name of this mode of transport */
    public val product: String?,

    /** The product id of this mode of transport */
    public val productId: String?,

    /** The interchange type of this mode of transport */
    public val type: InterchangeType,

    /** The means of transport code of this mode of transport */
    public val code: EfaMeansOfTransport?,

    // TODO: Purpose?
    public val mtSubcode: Int?,

    /** The destination name of this mode of transport */
    public val destination: String?,

    /** The stop id of the destination */
    public val destID: Long?,

    /** Returns a readable description of this mode of transport */
    public val desc: String?,

    /** The timetable period of this mode of transport */
    public val timetablePeriod: String?,

    /** Whether realtime information is valid on this mode of transport */
    public val realtime: Boolean = false,

    /** The diva object of this mode of transport */
    public val diva: Diva,
) {

    @Serializable(with = EfaInterchangeTypeAdapter::class)
    public sealed class InterchangeType {
        public class Icon(public val type: Int) : InterchangeType()
        public object DoNotChange : InterchangeType()
        public object SecureConnection : InterchangeType()
        public object Footway : InterchangeType()
        public object Transfer : InterchangeType()
    }

    @Serializable
    public data class Diva(
        public val branch: String?,
        public val line: String?,
        public val supplement: String?,
        public val dir: String?,
        public val project: String?,
        public val network: String?,
        public val stateless: String?,
        public val operator: String?,
        public val tripCode: Long?,
        public val opCode: String?,
        public val opPublicCode: String?,
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        public val vF: LocalDate?,
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        public val vTo: LocalDate?,
        public val isTTB: String?,
        public val isSTT: String?,
        public val lineDisplay: EfaServingLine.LineDisplay?,
        @Serializable(with = EfaMapListSerializer::class)
        public val attrs: Map<String, String> = emptyMap(),
    )
}