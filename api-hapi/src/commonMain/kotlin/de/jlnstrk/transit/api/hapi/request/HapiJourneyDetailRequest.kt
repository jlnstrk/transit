package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.api.hafas.HafasRealtimeMode
import de.jlnstrk.transit.api.hapi.HapiService
import de.jlnstrk.transit.api.hapi.request.delegate.*
import de.jlnstrk.transit.api.hapi.response.HapiJourneyDetail
import de.jlnstrk.transit.util.LocalDate

public class HapiJourneyDetailRequest : HapiRequest<HapiJourneyDetail>() {
    override val service: HapiService get() = HapiService.JOURNEY_DETAIL

    /** Specifies the internal journey id of the journey shall be retrieved */
    public var id: String? by HapiStringParam

    /** Day of operation */
    public var date: LocalDate? by HapiLocalDateParam

    /** Enables/disables the calculation of the polyline for each leg of the trip except any GIS route */
    public var poly: Boolean? by HapiBooleanParam

    /** Defines encoding of the returned polyline */
    public var polyEnc: HafasPolylineEncoding? by HapiEnumParam()

    /** Enables/disables the return of stops having no alighting and no boarding in its passlist
     * for each leg of the trip */
    public var showPassingPoints: Boolean? by HapiBooleanParam

    /** Set the realtime mode to be used if enabled */
    public var rtMode: HafasRealtimeMode? by HapiEnumParam()

    /** Specifies the station/stop ID the partial itinerary shall start from */
    public var fromId: String? by HapiStringParam

    /** Specifies the station/stop index the partial itinerary shall start from */
    public var fromIdx: Int? by HapiIntParam

    /** Specifies the station/stop ID the partial itinerary shall end at */
    public var toId: String? by HapiStringParam

    /** Specifies the station/stop index the partial itinerary shall end at */
    public var toIdx: Int? by HapiIntParam

    /** Enables/disables BAIM search and response */
    public var baim: Boolean? by HapiBooleanParam

    public companion object {
        public inline operator fun invoke(init: HapiJourneyDetailRequest.() -> Unit): HapiJourneyDetailRequest =
            HapiJourneyDetailRequest().apply(init)
    }
}