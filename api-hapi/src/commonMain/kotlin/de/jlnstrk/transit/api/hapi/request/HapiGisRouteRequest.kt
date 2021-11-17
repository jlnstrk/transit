package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.api.hapi.request.delegate.HapiBooleanParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiEnumParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiStringParam
import de.jlnstrk.transit.api.hapi.response.HapiTripList

public class HapiGisRouteRequest : HapiRequest<HapiTripList>() {
    override val service: HapiEndpoint get() = HapiEndpoint.GIS_ROUTE

    /** Specifies the GIS route context */
    public var ctx: String? by HapiStringParam

    /** Enables/disables the calculation of the polyline */
    public var poly: Boolean? by HapiBooleanParam

    /** Defines encoding of the returned polyline */
    public var polyEnc: HafasPolylineEncoding? by HapiEnumParam()

    /** Enables/disables eco value calculation */
    public var eco: Boolean? by HapiBooleanParam

    public companion object {
        public inline operator fun invoke(init: HapiGisRouteRequest.() -> Unit): HapiGisRouteRequest =
            HapiGisRouteRequest().apply(init)
    }
}