@file:UseSerializers(
    HapiLocalDateSerializer::class,
    HapiLocalTimeSerializer::class,
    HapiZoneOffsetSerializer::class
)

package de.jlnstrk.transit.client.hapi.model.stop

import de.jlnstrk.transit.client.hafas.HafasPrognosisType
import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiNote
import de.jlnstrk.transit.client.hapi.model.HapiOccupancy
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalTimeSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiZoneOffsetSerializer
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** The element Stop contains the name of the stop/station, the route index, the latitude, the longitude,
 * the departure time and date, the arrival time and date, the track, the realtime departure time and date,
 * the realtime arrival time and date and the realtime track. */
@HapiXsd("1.29")
@Serializable
public data class HapiStop(
    /** Contains the name of the stop/station. */
    public val name: String,
    /** Contains the ID of the stop/station. */
    public val id: String,
    /** Contains the external ID of the stop/station. */
    public val extId: String,
    /** Route index of a stop/station. Usually starting from 0 and incrementing by 1.
     * If the route index value jumps, it is most likely that the journey was rerouted. */
    public val routeIdx: Int?,
    /** The WGS84 longitude of the geographical position of the stop/station. */
    public val lon: Double?,
    /** The WGS84 latitude of the geographical position of the stop/station */
    public val lat: Double?,
    /** Prognosis type of arrival date and time. */
    public val arrPrognosisType: HafasPrognosisType? = null,
    /** Prognosis type of departure date and time. */
    public val depPrognosisType: HafasPrognosisType? = null,
    /** Departure time in format hh:mm[:ss], if available. */
    public val depTime: LocalTime?,
    /** Departure date in format YYYY-MM-DD, if available. */
    public val depDate: LocalDate?,
    /** Departure time zone information in the format +/- minutes */
    public val depTz: UtcOffset = UtcOffset(0),
    /** Scheduled departure time changed. */
    public val scheduledDepTimeChanged: Boolean = false,
    /** Arrival time in format hh:mm[:ss], if available. */
    public val arrTime: LocalTime?,
    /** Arrival date in format YYYY-MM-DD, if available. */
    public val arrDate: LocalDate?,
    /** Arrival time zone information in the format +/- minutes */
    public val arrTz: UtcOffset = UtcOffset(0),
    /** Scheduled arrival time changed. */
    public val scheduledArrTimeChanged: Boolean = false,
    /** Passing time in format hh:mm[:ss], if available. */
    public val passingTime: LocalTime?,
    /** Passing date in format YYYY-MM-DD, if available. */
    public val passingDate: LocalDate?,
    /** Passing time zone information in the format +/- minutes */
    public val passingTz: UtcOffset = UtcOffset(0),
    /** Arrival track information, if available. */
    public val arrTrack: String?,
    /** Departure track information, if available. */
    public val depTrack: String?,
    /** Realtime departure time in format hh:mm[:ss] if available. */
    public val rtDepTime: LocalTime?,
    /** Realtime departure date in format YYYY-MM-DD, if available. */
    public val rtDepDate: LocalDate?,
    /** Realtime departure time zone information in the format +/- minutes, if available. */
    public val rtDepTz: UtcOffset = UtcOffset(0),
    /** Realtime arrival time in format hh:mm[:ss] if available. */
    public val rtArrTime: LocalTime?,
    /** Realtime arrival date in format YYYY-MM-DD, if available. */
    public val rtArrDate: LocalDate?,
    /** Realtime arrival time zone information in the format +/- minutes, if available. */
    public val rtArrTz: UtcOffset = UtcOffset(0),
    /** Realtime arrival track information, if available. */
    public val rtArrTrack: String?,
    /** Realtime departure track information, if available. */
    public val rtDepTrack: String?,
    /** Realtime passing time in format hh:mm[:ss], if available. */
    public val rtPassingTime: LocalTime?,
    /** Realtime passing date in format YYYY-MM-DD, if available. */
    public val rtPassingDate: LocalDate?,
    /** Realtime passing time zone information in the format +/- minutes, if available. */
    public val rtPassingTz: UtcOffset = UtcOffset(0),
    /** Will be true if arrival or departure or both at this stop is cancelled */
    public val cancelled: Boolean = false,
    /** Will be true if departure at this stop is cancelled */
    public val cancelledDeparture: Boolean = false,
    /** Will be true if arrival at this stop is cancelled */
    public val cancelledArrival: Boolean = false,
    /** True if this stop belongs to a main mast. */
    public val hasMainMast: Boolean?,
    /** ID of the main mast this stop belongs to. */
    public val mainMastId: String?,
    /** External ID of the main mast this stop belongs to. */
    public val mainMastExtId: String?,
    /** True if alighting is allowed by scheduled data */
    public val alighting: Boolean?,
    /** True if boarding is allowed by scheduled data */
    public val boarding: Boolean?,
    /** True if alighting is allowed by realtime data */
    public val rtAlighting: Boolean?,
    /** True if boarding is allowed by realtime data */
    public val rtBoarding: Boolean?,
    /** Will be true if this stop is an additional stop */
    public val additional: Boolean = false,
    /** Will be true if this stop is a border stop */
    public val isBorderStop: Boolean = false,
    /** Direction information. */
    public val depDir: String?,
    /** True, if the stop is an entry point. */
    public val entry: Boolean?,
    /** Contains a list of notes to be displayed for this location, like attributes or footnotes. */
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Notes: List<HapiNote> = emptyList(),
    public val altId: List<String> = emptyList(),
    public val mainMastAltId: List<String> = emptyList(),
    public val Occupancy: List<HapiOccupancy> = emptyList(),
)