package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.model.location.HapiLocationType
import de.jlnstrk.transit.api.hapi.request.delegate.HapiIntParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiQueryParam
import de.jlnstrk.transit.api.hapi.request.delegate.HapiStringParam
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse

public sealed class HapiLocationRequest<Res : HapiResponse> : HapiRequest<Res>() {
    /** Maximum number of returned stops. Range from 1 to 1000 */
    public var maxNo: Int? by HapiIntParam

    /** Type filter for location types */
    public var type: Set<HapiLocationType>? by HapiQueryParam(
        serialize = { "ALL" },
        deserialize = { emptySet() }
    )

    /** Selection mode for locations */
    public var locationSelectionMode: String? by HapiStringParam

    /** Search radius in meter around the given coordinate if any */
    public var r: Int? by HapiIntParam

    /** Filter by a predefined meta filter. If the rules of the predefined filter should not be negated,
     * put ! in front of it */
    public var meta: String? by HapiStringParam

    /** Filter locations by one or more attribute codes. Multiple attribute codes are separated by comma.
     * If the attribute should not be part of the location data, negate it by putting ! in front of it */
    public var sattributes: String? by HapiStringParam
}