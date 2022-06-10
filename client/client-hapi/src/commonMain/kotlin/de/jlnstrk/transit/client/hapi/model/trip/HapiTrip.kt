@file:UseSerializers(
    HapiDurationSerializer::class
)

package de.jlnstrk.transit.client.hapi.model.trip

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.*
import de.jlnstrk.transit.client.hapi.model.stop.HapiDestination
import de.jlnstrk.transit.client.hapi.model.stop.HapiOrigin
import de.jlnstrk.transit.client.hapi.model.tariff.HapiTariffResult
import de.jlnstrk.transit.client.hapi.serializer.HapiDurationSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlin.time.Duration

@HapiXsd("1.29")
@Serializable
public data class HapiTrip(
    /** The type indicates whether this is an original connection or an realtime alternative. */
    public val alternative: Boolean = false,
    /** The type indicates whether this trip is based on individual change times (true) or not (false).
     * Default is false. */
    public val individualChangeTimes: Boolean = false,
    /** The state indicates if the trip is still possible to ride based on the current realtime situation. */
    public val valid: Boolean = true,
    /** The index of this trip in the result list. It corresponds to date and time order ascending;
     * unique within the composite TripResponse. */
    public val idx: Int?,
    /** The trip id of this trip in the result list. */
    public val tripId: String?,
    /** Information for trip reconstruction. */
    public val ctxRecon: String?,
    /** The duration of the trip. */
    public val duration: Duration?,
    /** Realtime duration of the trip. */
    public val rtDuration: Duration?,
    /** true: indicates the trip is a return journey. */
    @SerialName("return")
    public val ret: Boolean = false,
    /** Contains a precalculated url. */
    public val ecoUrl: String?,
    /** Checksum of the trip to filter same results on client side after scroll requests. */
    public val checksum: String?,
    /** Count of transfers. */
    public val transferCount: Int = 0,

    public val Origin: HapiOrigin?,
    public val Destination: HapiDestination?,
    public val Messages: List<HapiMessage> = emptyList(),
    public val Notes: List<HapiNote> = emptyList(),
    public val Eco: HapiEco?,
    public val ServiceDays: List<HapiServiceDays> = emptyList(),
    public val Freq: HapiFrequency?,
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val LegList: List<HapiLeg> = emptyList(),
    public val TariffResult: HapiTariffResult?,
    public val calculation: HapiCalculationType?,
    public val Occupancy: HapiOccupancy?,
    public val reliability: HapiConnectionReliability?,
)