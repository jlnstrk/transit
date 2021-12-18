@file:UseSerializers(
    HapiDurationSerializer::class
)

package de.jlnstrk.transit.client.hapi.model.trip

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.*
import de.jlnstrk.transit.client.hapi.model.gis.HapiGisRoute
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourneyStatus
import de.jlnstrk.transit.client.hapi.model.stop.HapiDestination
import de.jlnstrk.transit.client.hapi.model.stop.HapiOrigin
import de.jlnstrk.transit.client.hapi.model.stop.HapiStop
import de.jlnstrk.transit.client.hapi.serializer.HapiDurationSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiOptionalListSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiReferenceUnwrapSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiLeg(
    /** Specifies the index of the leg starting from 0 and incrementing by 1.
     * It corresponds to travel-order ascending; unique within composite Trip. */
    public val idx: Int,
    /** The attribute name specifies the name of the leg (e.g. "Bus 100"). */
    public val name: String?,
    /** The train number. */
    public val number: String?,
    /** The train category name. The category assignments are stored in the "zugart" file of the raw Hafas plan data. */
    public val category: String?,
    /** The attribute type specifies the type of the leg.
     * The value can be the JNY for public transport or WALK, TRSF (transfer), BIKE, KISS (car), PARK (Park and Ride)
     * or TAXI, CHKI (check-in), CHKO (check-out) or TETA (Tele taxi). */
    public val type: Type? = null,
    /** Will be true if this journey is cancelled. */
    public val cancelled: Boolean = false,
    /** Will be true if this journey is partially cancelled. */
    public val partCancelled: Boolean = false,
    /** Will be true if this journey is reachable. */
    public val reachable: Boolean = true,
    /** Will be true if this journey is redirected. */
    public val redirected: Boolean = false,
    /** Direction information. This will be the name of the last station of the train's journey.
     * Call the JourneyDetail service to get detailed information about the train journey. */
    public val direction: String?,
    /** The duration. */
    public val duration: Duration?,
    /** Distance for this leg in meter. */
    public val dist: Int?,
    /** Will be true if this journey is hidden. */
    public val hide: Boolean = false,
    /** Provides a context that may be used in service PartialSearch to increase the time for interchange
     * between the previous journey arrival stop and the following journey departure stop by searching a trip
     * that will lead to an earlier arrival time for the previous journey while keeping the departure time for
     * the following journey(s) constant. */
    public val psCtxArriveEarlier: String?,
    /** Provides a context that may be used in service PartialSearch to increase the time for interchange
     * between the previous journey arrival stop and the following journey departure stop by searching a trip
     * that will lead to a later departure time for the following journey while keeping the arrival time for
     * the previous journey(s) constant */
    public val psCtxDepartureLater: String?,
    public val Origin: HapiOrigin,
    public val Destination: HapiDestination,
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Notes: List<HapiNote> = emptyList(),
    @Serializable(with = HapiReferenceUnwrapSerializer::class)
    public val JourneyDetailRef: String?,
    public val Freq: HapiFrequency?,
    @Serializable(with = HapiReferenceUnwrapSerializer::class)
    public val GisRef: String?,
    public val GisRoute: HapiGisRoute?,
    public val Messages: List<HapiMessage> = emptyList(),
    public val JourneyStatus: HapiJourneyStatus? = null,
    @Serializable(with = HapiOptionalListSerializer::class)
    public val Product: List<HapiProduct> = emptyList(),
    public val Polyline: HapiPolyline?,
    public val PolylineGroup: HapiPolylineGroup?,
    public val Stops: List<HapiStop> = emptyList(),
    public val ServiceDays: List<HapiServiceDays> = emptyList(),
    public val ParallelJourney: List<HapiJourney> = emptyList(),
    public val Occupancy: List<HapiOccupancy> = emptyList(),
) {

    @Serializable
    public enum class Type {
        WALK,
        TRSF,
        BIKE,
        KISS,
        PARK,
        TAXI,
        CHKI,
        CHKO,
        TETA,
    }
}