package de.jlnstrk.transit.client.hapi.request

import de.jlnstrk.transit.client.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.client.hafas.HafasRealtimeMode
import de.jlnstrk.transit.client.hapi.HapiEndpoint
import de.jlnstrk.transit.client.hapi.request.base.HapiFilterList
import de.jlnstrk.transit.client.hapi.request.delegate.*
import de.jlnstrk.transit.client.hapi.response.HapiTripList
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlin.time.Duration

public class HapiTripRequest : HapiRequest<HapiTripList>() {
    override val service: HapiEndpoint get() = HapiEndpoint.TRIP

    /** Specifies the station/stop ID of the origin for the trip.
     * Such ID can be retrieved from the location.name or location.nearbystops services */
    public var originId: String? by HapiStringParam

    /** Specifies the external station/stop ID of the origin for the trip.
     * Such ID can be retrieved from the location.name or location.nearbystops services */
    @Deprecated("Please use `originId` as it supports external IDs")
    public var originExtId: String? by HapiStringParam

    /** Latitude of station/stop coordinate of the trip’s origin.
     * The coordinate can be retrieved from the location.name or location.nearbystops services */
    public var originCoordLat: Double? by HapiDoubleParam

    /** Longitude of station/stop coordinate of the trip’s origin.
     * The coordinate can be retrieved from the location.name or location.nearbystops services */
    public var originCoordLong: Double? by HapiDoubleParam

    /** Name of the trip's origin */
    public var originCoordName: String? by HapiStringParam

    /** Specifies the station/stop ID of the destination for the trip.
     * Such ID can be retrieved from the location.name or location.nearbystops services */
    public var destId: String? by HapiStringParam

    /** Specifies the external station/stop ID of the destination for the trip.
     * Such ID can be retrieved from the location.name or location.nearbystops services */
    @Deprecated("Please use `destId` as it supports external IDs")
    public var destExtId: String? by HapiStringParam

    /** Latitude of station/stop coordinate of the trip’s destination.
     * The coordinate can be retrieved from the location.name or location.nearbystops services */
    public var destCoordLat: Double? by HapiDoubleParam

    /** Longitude of station/stop coordinate of the trip’s destination.
     * The coordinate can be retrieved from the location.name or location.nearbystops services */
    public var destCoordLong: Double? by HapiDoubleParam

    /** Name of the trip's destination */
    public var destCoordName: String? by HapiStringParam

    /** Complex structure to provide multiple via points separated by semicolon */
    public var via: String? by HapiStringParam

    /** ID of a station/stop used as a via for the trip. Specifying a via station forces the trip search
     * to look for trips which must pass through this station.
     * Such IDs can be retrieved from the location.name or location.nearbystops services */
    public var viaId: String? by HapiStringParam

    /** Defines the waiting time spent at via station in minutes */
    public var viaWaitTime: Duration? by HapiMinutesParam

    /** Complex structure to provide multiple points to be avoided separated by semicolon */
    public var avoid: String? by HapiStringParam

    /** ID of a station/stop to be avoided as transfer stop for the trip.
     * Such IDs can be retrieved from the location.name or location.nearbystops services */
    public var avoidId: String? by HapiStringParam

    /** Configures the walking speed when changing from one leg of the journey to the next one.
     * It extends the time required for changes by a specified percentage.
     * A value of 200 doubles the change time as initially calculated by the system */
    public var changeTimePercent: Int? by HapiIntParam

    /** Minimum change time at stop in minutes */
    public var minChangeTime: Duration? by HapiMinutesParam

    /** Maximum change time at stop in minutes */
    public var maxChangeTime: Duration? by HapiMinutesParam

    /** This amount of minutes is added to the change time at each stop */
    public var addChangeTime: Duration? by HapiMinutesParam

    /** Maximum number of changes. Range from 0 to 11 */
    public var maxChange: Int? by HapiIntParam

    /** Sets the start date for which the departures shall be retrieved. Represented in the format YYYY-MM-DD */
    public var date: LocalDate? by HapiLocalDateParam

    /** Sets the start time for which the departures shall be retrieved.
     * Represented in the format hh:mm[:ss] in 24h nomenclature. Seconds will be ignored for requests */
    public var time: LocalTime? by HapiLocalTimeParam

    /** If set, the date and time parameters specify the arrival time for the trip search
     * instead of the departure time */
    public var searchForArrival: Boolean? by HapiBooleanParam

    /** Minimum number of trips after the search time. Sum of numF and numB has to be less or equal 6.
     * Range from 0 to 6 */
    public var numF: Int? by HapiIntParam

    /** Minimum number of trips before the search time. Sum of numF and numB has to be less or equal 6.
     * Range from 0 to 6 */
    public var numB: Int? by HapiIntParam

    /** Defines the starting point for the scroll back or forth operation.
     * Use the scrB value from a previous result to scroll backwards in time
     * and use the scrF value to scroll forth */
    public var context: String? by HapiStringParam

    /** Enables/disables the calculation of the polyline for each leg of the trip except any GIS route */
    public var poly: Boolean? by HapiBooleanParam

    /** Defines encoding of the returned polyline */
    public var polyEnc: HafasPolylineEncoding? by HapiEnumParam()

    /** Enables/disables the return of the passlist for each leg of the trip */
    public var passlist: Boolean? by HapiBooleanParam

    /** Decimal value defining the product classes to be included in the search.
     * It represents a bitmask combining bit number of a product as defined in the HAFAS raw data file zugart */
    public var products: Int? by HapiIntParam

    /** Only trips provided by the given operators are part of the result.
     * To filter multiple operators, separate the codes by comma.
     * If the operator should not be part of the be trip, negate it by putting ! in front of it */
    public var operators: HapiFilterList? by HapiFilterListParam

    /** Filter trips by one or more attribute codes of a journey. Multiple attribute codes are separated by comma.
     * If the attribute should not be part of the be trip, negate it by putting ! in front of it */
    public var attributes: HapiFilterList? by HapiFilterListParam

    /** Filter trips by one or more station attribute codes of a journey.
     * Multiple attribute codes are separated by comma. If the attribute should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var sattributes: HapiFilterList? by HapiFilterListParam

    /** Filter trips by one or more footway attribute codes of a journey.
     * Multiple attribute codes are separated by comma. If the attribute should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var fattributes: HapiFilterList? by HapiFilterListParam

    /** Only journeys running the given line are part of the result. To filter multiple lines,
     * separate the codes by comma. If the line should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var lines: HapiFilterList? by HapiFilterListParam

    /** Only journeys running the given line (identified by its line ID) are part of the result.
     * o filter multiple lines, separate the line IDs by comma. If the line should not be part of the be trip,
     * negate it by putting ! in front of it */
    public var lineids: HapiFilterList? by HapiFilterListParam

    /** Only path not having the given properties will be part of the result */
    public var avoidPaths: List<String>? by HapiStringListParam

    /** Enables/disables using footpaths in the beginning of a trip when searching from an address */
    public var originWalk: Boolean? by HapiBooleanParam

    /** Enables/disables using bike routes in the beginning of a trip when searching from an address */
    public var originBike: Boolean? by HapiBooleanParam

    /** Enables/disables using car in the beginning of a trip when searching from an address */
    public var originCar: Boolean? by HapiBooleanParam

    /** Enables/disables using taxi rides in the beginning of a trip when searching from an address */
    public var originTaxi: Boolean? by HapiBooleanParam

    /** Enables/disables using Park and Ride in the beginning of a trip when searching from an address */
    public var originPark: Boolean? by HapiBooleanParam

    /** Enables using one or more predefined individual transport meta profile at the beginning of a trip.
     * The profiles are defined in the HAFAS installation */
    public var originMeta: Boolean? by HapiBooleanParam

    /** Enables/disables using footpaths at the end of a trip when searching to an address */
    public var destWalk: Boolean? by HapiBooleanParam

    /** Enables/disables using bike routes at the end of a trip when searching to an address */
    public var destBike: Boolean? by HapiBooleanParam

    /** Enables/disables using car routes at the end of a trip when searching to an address */
    public var destCar: Boolean? by HapiBooleanParam

    /** Enables/disables using taxi rides at the end of a trip when searching to an address */
    public var destTaxi: Boolean? by HapiBooleanParam

    /** Enables/disables using Park and Ride at the end of a trip when searching to an address */
    public var destPark: Boolean? by HapiBooleanParam

    /** Enables using one or more predefined individual transport meta profile at the end of a trip.
     * The profiles are defined in the HAFAS installation */
    public var destMeta: Boolean? by HapiBooleanParam

    /** Enables/disables using footpaths for the whole trip */
    public var totalWalk: Boolean? by HapiBooleanParam

    /** Enables/disables using bike routes for the whole trip */
    public var totalBike: Boolean? by HapiBooleanParam

    /** Enables/disables using car routes for the whole trip */
    public var totalCar: Boolean? by HapiBooleanParam

    /** Enables/disables using taxi rides for the whole trip */
    public var totalTaxi: Boolean? by HapiBooleanParam

    /** Enables using one or more predefined individual transport meta profile for a trip.
     * The profiles are defined in the HAFAS installation */
    public var totalMeta: Boolean? by HapiBooleanParam

    /** Enables/disables search for individual transport routes */
    public var includeIv: Boolean? by HapiBooleanParam

    /** Enables/disables search for individual transport routes only */
    public var ivOnly: Boolean? by HapiBooleanParam

    /** Use a predefined filter by its name. The filters are defined in the HAFAS installation.
     * If the filter should be negated, put a ! in front of its name */
    public var mobilityProfile: HapiFilterList? by HapiFilterListParam

    /** Enables/disables search for trips explicit allowing bike carriage */
    public var bikeCarriage: Boolean? by HapiBooleanParam

    /** Enables/disables search for trips having sleeping car */
    public var sleepingCar: Boolean? by HapiBooleanParam

    /** Enables/disables search for trips having couchette coach */
    public var couchetteCar: Boolean? by HapiBooleanParam

    /** Enables/disables the return of stops having no alighting and boarding in its passlist for each leg of the trip.
     * Needs passlist enabled */
    public var showPassingPoints: Boolean? by HapiBooleanParam

    /** Enables/disables BAIM search and response */
    public var baim: Boolean? by HapiBooleanParam

    /** Enables/disables eco value calculation */
    public var eco: Boolean? by HapiBooleanParam

    /** Enables/disables eco comparison */
    public var ecoCmp: Boolean? by HapiBooleanParam

    /** Provide additional eco parameters */
    public var ecoParams: String? by HapiStringParam

    /** Set the realtime mode to be used */
    public var rtMode: HafasRealtimeMode? by HapiEnumParam()

    /** Enables/disables unsharp search mode */
    public var unsharp: Boolean? by HapiBooleanParam

    /** Filters a trip search for a certain train */
    public var trainFilter: String? by HapiStringParam

    /** Enables/disables economic search mode */
    public var economic: Boolean? by HapiBooleanParam

    /** Use a predefined group filter to query for certain modes */
    public var groupFilter: String? by HapiStringParam

    /** Defines a section of a route of a journey not to be used within the trip search */
    public var blockingList: String? by HapiStringParam

    /** Enables/disables train composition data */
    public var trainComposition: Boolean? by HapiBooleanParam

    /** Disables search optimization in relation of duration */
    public var includeEarlier: Boolean? by HapiBooleanParam

    /** Enables/disables the search for alternatives with individualized change times (ICT) */
    public var withICTAlternatives: Boolean? by HapiBooleanParam

    /** Enables/disables the output of tariff data. The default is configurable via provisioning */
    public var tariff: Boolean? by HapiBooleanParam

    /** Enables/disables the output of traffic messages. The default is configurable via provisioning */
    public var trafficMessages: Boolean? by HapiBooleanParam

    public companion object {
        public inline operator fun invoke(init: HapiTripRequest.() -> Unit): HapiTripRequest =
            HapiTripRequest().apply(init)
    }
}