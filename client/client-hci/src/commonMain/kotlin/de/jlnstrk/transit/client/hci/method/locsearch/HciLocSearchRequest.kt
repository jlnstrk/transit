package de.jlnstrk.transit.client.hci.method.locsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciLocationFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocSearchRequest(
    public var getAttributes: Boolean? = null,
    public var getInfotexts: Boolean? = null,
    public var getPOIs: Boolean? = null,
    public var getProducts: Boolean? = null,
    public var getStops: Boolean? = null,
    public var locFltrL: List<HciLocationFilter> = emptyList(),
    public var maxLoc: Int? = null
) : HciServiceRequest<HciLocSearchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_SEARCH

    public companion object {
        public operator fun invoke(init: HciLocSearchRequest.() -> Unit): HciLocSearchRequest =
            HciLocSearchRequest().apply(init)
    }
}