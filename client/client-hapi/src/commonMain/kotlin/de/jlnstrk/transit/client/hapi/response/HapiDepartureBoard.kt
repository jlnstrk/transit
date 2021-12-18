package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiDeparture
import de.jlnstrk.transit.client.hapi.model.HapiMessage
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** The departure board lists departures at a specific stop/station or group of stop/stations. */
@HapiXsd("1.29")
@Serializable
public data class HapiDepartureBoard(
    /** The element Departure contains all information about a departure like time, date, stop/station name, track,
     * realtime time, date and track, direction, name and type of the journey.
     * It also contains a reference to journey details. */
    public val Departure: List<HapiDeparture> = emptyList(),
    public val Message: List<HapiMessage> = emptyList(),
    /** Contains the ID of the stop/station. */
    public val stopid: String,
    /** External ID of this stop/station */
    public val stopExtId: String
) : HapiResponse()