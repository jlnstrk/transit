@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.EfaCoordinatesStringSerializer
import de.jlnstrk.transit.api.efa.serializer.generic.EfaMapListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaReference(
    /** The referred location's id */
    public val id: Long,

    // TODO: Purpose?
    public val area: String? = null,

    /** The platform if this is a stop's reference  */
    public val platform: String? = null,

    /** The global id of the referred location */
    public val gid: String? = null,

    // TODO: Purpose?
    public val areaGid: String? = null,

    // TODO: Purpose?
    public val pointGid: String? = null,

    /** The referred location's municipal code */
    public val omc: Long? = null,

    // TODO: Purpose?
    public val zone: String? = null,

    /** The attributes associated with this reference */
    @Serializable(with = EfaMapListSerializer::class)
    public val attrs: Map<Attribute, String> = emptyMap(),

    /** The id of the referred location's place */
    public val placeID: Long? = null,

    /** The name of the referred location's place */
    public val place: String? = null,

    /** The referred location's coordinates */
    @Serializable(with = EfaCoordinatesStringSerializer::class)
    public val coords: EfaCoordinates? = null,

    /** The platform niveau if this is a stop's reference */
    public val niveau: Int? = null,

    /** The departure datetime with seconds if this is a stop's reference */
    @Serializable(with = EfaStringDateTimeSerializer.DateTime::class)
    public val depDateTimeSec: LocalDateTime? = null,

    /**
     * The departure delay if this is a stop's reference
     * Valid if [depValid]
     */
    @Serializable(with = EfaMinutesSerializer::class)
    public val depDelay: Duration? = null,

    /** Whether the departure delay is valid */
    public val depValid: Boolean = false,

    /** The arrival datetime with seconds if this is a stop's reference */
    @Serializable(with = EfaStringDateTimeSerializer.DateTime::class)
    public val arrDateTimeSec: LocalDateTime? = null,

    /**
     * The arrival delay if this is a stop's reference
     * Valid if [arrValid]
     */
    @Serializable(with = EfaMinutesSerializer::class)
    public val arrDelay: Duration? = null,

    /** Whether the arrival delay is valid */
    public val arrValid: Boolean = false
) {

    @Serializable
    public enum class Attribute {
        AREA_NIVEAU_DIVA,
        AREA_NIVEAU_GIS,

        @SerialName("platformChange")
        PLATFORM_CHANGE,
    }
}