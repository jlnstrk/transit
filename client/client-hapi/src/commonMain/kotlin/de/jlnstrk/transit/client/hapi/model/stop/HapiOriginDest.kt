@file:UseSerializers(
    HapiLocalDateSerializer::class,
    HapiLocalTimeSerializer::class,
    HapiZoneOffsetSerializer::class
)

package de.jlnstrk.transit.client.hapi.model.stop

import de.jlnstrk.transit.client.hafas.HafasPrognosisType
import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiMessage
import de.jlnstrk.transit.client.hapi.model.HapiNote
import de.jlnstrk.transit.client.hapi.model.HapiOccupancy
import de.jlnstrk.transit.client.hapi.model.HapiPair
import de.jlnstrk.transit.client.hapi.model.location.HapiLocationType
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalTimeSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiZoneOffsetSerializer
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiOriginDest(
    /** Contains the name of the location. */
    public val name: String,
    /** The attribute type specifies the type of location. Valid values are ST (stop/station), ADR (address),
     * POI (point of interest), CRD (coordinate), MCP (mode change point) or HL (hailing point). */
    public val type: HapiLocationType,
    /** ID of this stop */
    public val id: String?,
    /** External ID of this stop */
    public val extId: String?,
    /** The WGS84 longitude of the geographical position. */
    public val lon: Double?,
    /** The WGS84 latitude of the geographical position. */
    public val lat: Double?,
    /** Route index of a stop/station. Can be used as a reference of the stop/station in a journeyDetail response. */
    public val routeIdx: Int?,
    /** Prognosis type of date and time. */
    public val prognosisType: HafasPrognosisType? = null,
    /** Time in format hh:mm[:ss]. */
    public val time: LocalTime,
    /** Date in format YYYY-MM-DD. */
    public val date: LocalDate,
    /** Time zone information in the format +/- minutes */
    public val tz: UtcOffset = UtcOffset(0),
    /** Scheduled time changed. */
    public val scheduledTimeChanged: Boolean = false,
    /** Track information, if available. */
    public val track: String?,
    /** Realtime time in format hh:mm[:ss] if available. */
    public val rtTime: LocalTime?,
    /** Realtime date in format YYYY-MM-DD, if available. */
    public val rtDate: LocalDate?,
    /** Realtime time zone information in the format +/- minutes, if available. */
    public val rtTz: UtcOffset = UtcOffset(0),
    /** Realtime track information, if available. */
    public val rtTrack: String?,
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
    /** Will be true if arrival or departure or both at this stop is cancelled */
    public val cancelled: Boolean = false,
    /** Will be true if departure at this stop is cancelled */
    public val cancelledDeparture: Boolean = false,
    /** Will be true if arrival at this stop is cancelled */
    public val cancelledArrival: Boolean = false,
    /** Will be true if this stop is an additional stop */
    public val additional: Boolean = false,
    /** Will be true if this stop is a border stop */
    public val isBorderStop: Boolean = false,
    /** True, if the stop is an entry point. */
    public val entry: Boolean?,
    /** True if this stop is a mode change point, e.g. car sharing station, charging station etc. */
    public val mcp: Boolean = false,

    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Notes: List<HapiNote> = emptyList(),
    public val mcpData: List<HapiPair> = emptyList(),
    public val Message: List<HapiMessage> = emptyList(),
    public val altId: List<String> = emptyList(),
    public val mainMastAltId: List<String> = emptyList(),
    public val Occupancy: List<HapiOccupancy> = emptyList(),
)