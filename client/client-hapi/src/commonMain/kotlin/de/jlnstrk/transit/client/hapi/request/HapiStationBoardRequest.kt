package de.jlnstrk.transit.client.hapi.request

import de.jlnstrk.transit.client.hapi.request.base.HapiFilterList
import de.jlnstrk.transit.client.hapi.request.delegate.*
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlin.time.Duration

public sealed class HapiStationBoardRequest<Res : HapiResponse> : HapiRequest<Res>() {
    /** Specifies the station/stop ID for which the arrivals/departures shall be retrieved.
     * Required if extId is not present */
    public var id: String? by HapiStringParam

    /** Specifies the external station/stop ID for which the arrivals/departures shall be retrieved.
     * Required if id is not present */
    @Deprecated("Please use `id` as it supports external IDs")
    public var extId: String? by HapiStringParam

    /** If only vehicles departing or arriving from a certain direction shall be returned,
     * specify the direction by giving the station/stop ID of the last stop on the journey */
    public var direction: String? by HapiStringParam

    /** Sets the start date for which the arrivals/departures shall be retrieved.
     * Represented in the format YYYY-MM-DD */
    public var date: LocalDate? by HapiLocalDateParam

    /** Sets the start time for which the arrivals/departures shall be retrieved.
     * Represented in the format hh:mm[:ss] in 24h nomenclature. Seconds will be ignored for requests */
    public var time: LocalTime? by HapiLocalTimeParam

    /** Range from 0 to 1439 */
    @Deprecated("Replaced by `duration`")
    public var dur: Duration? by HapiMinutesParam

    /** Set the interval size in minutes. Range from 0 to 1439 */
    public var duration: Duration? by HapiMinutesParam

    /** Maximum number of journeys to be returned. If no value is defined or -1,
     * all departing/arriving services within the duration sized period are returned */
    public var maxJourneys: Int? by HapiIntParam

    /** Decimal value defining the product classes to be included in the search.
     * It represents a bitmask combining bit number of a product as defined in the HAFAS raw data file zugart */
    public var products: Int? by HapiIntParam

    /** Only journeys provided by the given operators are part of the result. To filter multiple operators,
     * separate the codes by comma. If the operator should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var operators: HapiFilterList? by HapiFilterListParam

    /** Only journeys running the given line are part of the result. To filter multiple lines,
     * separate the codes by comma. If the line should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var lines: HapiFilterList? by HapiFilterListParam

    /** Enables/disables the filtering of equivalent marked stops */
    public var filterEquiv: Boolean? by HapiBooleanParam

    /** Filter boards by one or more attribute codes of a journey. Multiple attribute codes are separated by comma.
     * If the attribute should not be part of the result, negate it by putting ! in front of it */
    public var attributes: HapiFilterList? by HapiFilterListParam

    /** Filter boards by platform. Multiple platforms are separated by comma */
    public var platforms: List<String>? by HapiQueryParam(
        serialize = { it.joinToString(separator = ",") },
        deserialize = { it.split(",") }
    )

    /** Set the realtime mode to be used if enabled */
    public var rtMode: String? by HapiStringParam

    /** Include a list of all passed waystops? */
    public var passlist: Boolean? by HapiBooleanParam
}