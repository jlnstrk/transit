@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.generic.EfaEnumMaskSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaFlatObjectDateTimeSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaMinutesSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/**
 * Describes the json structure encoding journeys from the XML_DM_REQUEST endpoint.
 * Appears at `$.departureList[] and $.arrivalList[]`
 */
@Serializable
public data class EfaJourney(
    /** The id of the stop where this journey is observed */
    public val stopID: Long,

    /** The x-coordinate of the stop position */
    public val x: Double,

    /** The y-coordinate of the stop position */
    public val y: Double,

    /** The coordinate system that was used to encode the coordinates */
    public val mapName: EfaCoordinateSystem,

    /** TODO: Purpose? */
    public val area: String,

    /** The code of the platform at which the vehicle stops */
    public val platform: String?,

    /** Returns a human readable name of the platform at which the vehicle stops */
    public val platformName: String?,

    /** The name of the stop where this journey is observed */
    public val stopName: String,

    /** The name of the stop, but without a place */
    public val nameWO: String,

    /** The global id of the stop where this journey is observed */
    public val gid: String?,

    /** The global id of ??? */
    public val pointGid: String?,

    /** TODO: Purpose? */
    public val pointType: String?,

    /** Returns a countdown to this journey's departure/arrival relative to the request time */
    @Serializable(with = EfaMinutesSerializer::class)
    public val countdown: Duration,

    /** The occupancy information of the journey at this stop, if available */
    public val occupancy: Occupancy? = null,

    /** The scheduled date and time of the arrival/departure event */
    @Serializable(with = EfaFlatObjectDateTimeSerializer::class)
    public val dateTime: LocalDateTime,

    /** The realtime date and time of the arrival/departure event, if available */
    @Serializable(with = EfaFlatObjectDateTimeSerializer::class)
    public val realDateTime: LocalDateTime?,

    /** The status of the realtime information associated with this journey */
    @Serializable(with = EfaEnumMaskSerializer::class)
    public val realtimeTripStatus: Set<RealtimeStatus> = emptySet(),

    /** The line serving this journey */
    public val servingLine: EfaServingLine,

    /** The operator of this journey */
    public val operator: EfaOperator?,

    /** The sequence of en-route stops that precede the one observed */
    @Serializable(with = EfaOptionalListSerializer::class)
    public val prevStopSeq: List<EfaStop>?,

    /** The sequence of en-route stops that succeed the one observed */
    @Serializable(with = EfaOptionalListSerializer::class)
    public val onwardStopSeq: List<EfaStop>?
) {

    /**
     * Describes a vehicle's current occupancy status on a journey
     */
    @Serializable
    public enum class Occupancy {
        FEW_SEATS,
        MANY_SEATS,
        STANDING_ONLY
    }

    /**
     * Describes the realtime information status of a journey
     */
    @Serializable
    public enum class RealtimeStatus {
        MONITORED,
        DEVIATION,
        EXTRA_STOPS,
        TRIP_CANCELLED
    }
}