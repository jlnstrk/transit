@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Serializable
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaSimpleTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaStop(
    public val name: String? = null,
    public val nameWO: String,
    public val nameWithPlace: String?,
    public val omc: Long,
    public val placeID: Long,
    public val place: String,
    public val platformName: String?,
    public val plannedPlatformName: String?,
    public val usage: Usage? = null,
    public val pointType: String?,
    public val desc: String?,
    public val stamp: Stamp?,
    public val ref: EfaReference
) {

    @Serializable
    public enum class Usage {
        @SerialName("departure")
        DEPARTURE,
        @SerialName("arrival")
        ARRIVAL
    }

    @Serializable
    public data class Stamp(
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        val date: LocalDate,

        @Serializable(with = EfaSimpleTimeSerializer::class)
        val time: LocalTime,

        @Serializable(with = EfaSimpleTimeSerializer::class)
        val timeSec: LocalTime,

        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        val rtDate: LocalDate,

        @Serializable(with = EfaSimpleTimeSerializer::class)
        val rtTimeSec: LocalTime,
    )
}