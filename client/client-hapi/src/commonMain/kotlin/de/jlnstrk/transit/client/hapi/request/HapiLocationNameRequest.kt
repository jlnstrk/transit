package de.jlnstrk.transit.client.hapi.request

import de.jlnstrk.transit.client.hapi.HapiEndpoint
import de.jlnstrk.transit.client.hapi.request.delegate.HapiDoubleParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiIntParam
import de.jlnstrk.transit.client.hapi.request.delegate.HapiStringParam
import de.jlnstrk.transit.client.hapi.response.HapiLocationList

public class HapiLocationNameRequest : HapiLocationRequest<HapiLocationList>() {
    override val service: HapiEndpoint get() = HapiEndpoint.LOCATION_NAME

    /** Search for that token */
    public var input: String? by HapiStringParam

    /** Decimal value defining the product classes to be included in the search.
     * It represents a bitmask combining bit number of a product as defined in the HAFAS raw data file zugart */
    public var products: Int? by HapiIntParam

    /** Latitude of centre coordinate */
    public var coordLat: Double? by HapiDoubleParam

    /** Longitude of centre coordinate */
    public var coordLong: Double? by HapiDoubleParam

    /** In case of an refinable location, this value takes the ID of the refinable one of a previous result */
    public var refineId: String? by HapiStringParam

    /** Filter for stations. Matches if the given value is prefix of any station in the itinerary.
     * Multiple values are separated by comma */
    public var stations: String? by HapiStringParam

    /** Filter modes for nearby searches */
    public var filterMode: String? by HapiStringParam

    public companion object {
        public inline operator fun invoke(init: HapiLocationNameRequest.() -> Unit): HapiLocationNameRequest =
            HapiLocationNameRequest().apply(init)
    }
}