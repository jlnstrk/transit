package de.jlnstrk.transit.api.hapi.request

import de.jlnstrk.transit.api.hapi.HapiService
import de.jlnstrk.transit.api.hapi.request.delegate.HapiStringParam
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse

public sealed class HapiRequest<Res : HapiResponse>(
    private val queryMap: MutableMap<String, String> = mutableMapOf()
) : MutableMap<String, String> by queryMap {
    @PublishedApi
    internal abstract val service: HapiService

    /** Access ID for identifying the requesting client */
    public var accessId: String? by HapiStringParam

    /** Request ID for identifying the request */
    public var requestId: String? by HapiStringParam

    /** The language of the journey planer */
    public var lang: String? by HapiStringParam
}