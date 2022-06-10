@file:UseSerializers(
    HapiLocalDateSerializer::class,
    HapiLocalTimeSerializer::class,
    HapiZoneOffsetSerializer::class
)

package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HafasPrognosisType
import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourneyStatus
import de.jlnstrk.transit.client.hapi.model.location.HapiLocationType
import de.jlnstrk.transit.client.hapi.model.stop.HapiStop
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalTimeSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiReferenceUnwrapSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiZoneOffsetSerializer
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** The element Arrival contains all information about a arrival like time, date, stop/station name, track,
 * realtime time, date and track, origin, name and type of the journey.
 * It also contains a reference to journey details. */
@HapiXsd("1.29")
@Serializable
public data class HapiArrival(
    /** Specifies the name of the arriving journey (e.g. "Bus 100") as used for display. */
    public val name: String,
    /** The attribute type specifies the type of arrivals location. Valid values are ST (stop/station), ADR (address),
     * POI (point of interest), CRD (coordinate), MCP (mode change point) or HL (hailing point). */
    public val type: HapiLocationType,
    /** Contains the name of the stop/station. */
    public val stop: String,
    /** Contains the ID of the stop/station. */
    public val stopid: String,
    /** External ID of this stop/station */
    public val stopExtId: String?,
    /** Prognosis type of arrival date and time. */
    public val prognosisType: HafasPrognosisType?,
    /** Time in format hh:mm[:ss] */
    public val time: LocalTime,
    /** Scheduled time changed. */
    public val scheduledTimeChanged: Boolean = false,
    /** Date in format YYYY-MM-DD. */
    public val date: LocalDate,
    /** Time zone information in the format +/- minutes */
    public val tz: UtcOffset = UtcOffset(0),
    /** Arrival track information, if available. */
    public val track: String?,
    /** Realtime time in format hh:mm[:ss] if available. */
    public val rtTime: LocalTime?,
    /** Realtime date in format YYYY-MM-DD, if available. */
    public val rtDate: LocalDate?,
    /** Realtime time zone information in the format +/- minutes, if available. */
    public val rtTz: UtcOffset = UtcOffset(0),
    /** Realtime track information, if available. */
    public val rtTrack: String?,
    /** Will be true if this journey is cancelled */
    public val cancelled: Boolean = false,
    /** Will be true if this journey is partially cancelled. */
    public val partCancelled: Boolean = false,
    /** Will be true if this journey is reachable. */
    public val reachable: Boolean = true,
    /** Will be true if this journey is redirected. */
    public val redirected: Boolean = false,
    /** Origin of the journey. This is the first stop of the journey.
     * Get the full journey of the train or bus with the JourneyDetails service. */
    public val origin: String?,
    /** Will be true if this stop is a border stop */
    public val isBorderStop: Boolean = false,
    /** True, if the stop is an entry point. */
    public val entry: Boolean?,

    @Serializable(with = HapiReferenceUnwrapSerializer::class)
    public val JourneyDetailRef: String,
    public val JourneyStatus: HapiJourneyStatus?,
    public val Product: List<HapiProduct> = emptyList(),
    public val Notes: List<HapiNote> = emptyList(),
    public val Messages: List<HapiMessage> = emptyList(),
    public val altId: List<String> = emptyList(),
    public val Stops: List<HapiStop> = emptyList(),
    public val Occupancy: List<HapiOccupancy> = emptyList(),
)