package de.jlnstrk.transit.api.hci.method.locwalksearch

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocWalkSearchRequest(
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLocWalkSearchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_WALK_SEARCH

    public companion object {
        public inline operator fun invoke(init: HciLocWalkSearchRequest.() -> Unit): HciLocWalkSearchRequest =
            HciLocWalkSearchRequest().apply(init)
    }
}