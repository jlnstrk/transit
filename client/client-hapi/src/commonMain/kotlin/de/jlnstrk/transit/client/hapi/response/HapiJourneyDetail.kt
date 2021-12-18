package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.*
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourneyStatus
import de.jlnstrk.transit.client.hapi.model.stop.HapiStop
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** The journey details contain a list of stops/stations and notes.
 * They also contain the journeys names and types. */
@HapiXsd("1.29")
@Serializable
public class HapiJourneyDetail(
    /** Will be true if this journey is cancelled. */
    public val cancelled: Boolean = false,
    /** Will be true if this journey is partially cancelled. */
    public val partCancelled: Boolean = false,
    /** Will be true if this journey is reachable. */
    public val reachable: Boolean = true,
    /** Will be true if this journey is redirected. */
    public val redirected: Boolean = false,

    public val Stops: List<HapiStop> = emptyList(),
    public val Names: List<HapiName> = emptyList(),
    public val Directions: List<HapiDirection> = emptyList(),
    public val Notes: List<HapiNote> = emptyList(),
    public val Messages: List<HapiMessage> = emptyList(),
    public val JourneyStatus: HapiJourneyStatus?,
    public val Polyline: HapiPolyline?,
    public val PolylineGroup: HapiPolylineGroup?,
    public val ServiceDays: List<HapiServiceDays> = emptyList(),
    /** Last position of running journey if any. */
    public val lastPos: HapiCoord?,
    /** Date and time of last position reported if any. */
    // TODO: Datetime format?
    public val lastPosReported: String?,
    /** Last passed stop referencing the route index of that stop, even if out of this part of the journey. */
    public val lastPassRouteIdx: Int?,
    /** Last passed stop referencing the entry index in the stop list, even if out of this part of the journey. */
    public val lastPassStopRef: Int?,
    /** Last passed stop referencing the route index of that stop,
     * even if out of this part of the journey, real time situation. */
    public val rtLastPassRouteIdx: Int?,
    /** Last passed stop referencing the entry index in the stop list, even if out of this part of the journey. */
    public val rtLastPassStopRef: Int?,
) : HapiResponse()