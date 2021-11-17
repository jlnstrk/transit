package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.api.hapi.request.delegate.HapiDoubleParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiIntParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiStringParam
import de.jlnstrk.transit.api.hapi.response.HapiLocationList

public class HapiLocationNearbyStopsRequest : HapiLocationRequest<HapiLocationList>() {
    override val service: HapiEndpoint get() = HapiEndpoint.LOCATION_NEARBYSTOPS

    /** Latitude of centre coordinate */
    public var originCoordLat: Double? by HapiDoubleParam
    /** Longitude of centre coordinate */
    public var originCoordLong: Double? by HapiDoubleParam
    /** Decimal value defining the product classes to be included in the search.
     * It represents a bitmask combining bit number of a product as defined in the HAFAS raw data file zugart*/
    public var products: Int? by HapiIntParam
    /** Filter locations by one or more station infotext codes and values.
     * Multiple attribute codes are separated by comma the value by pipe | */
    public var sinfotexts: String? by HapiStringParam

    public companion object {
        public inline operator fun invoke(init: HapiLocationNearbyStopsRequest.() -> Unit): HapiLocationNearbyStopsRequest =
            HapiLocationNearbyStopsRequest().apply(init)
    }
}