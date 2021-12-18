package de.jlnstrk.transit.client.hci.method.locgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocGraphRequest(
    public var date: String? = null,
    public var findAequivalent: Boolean? = null,
    public var getInAndOut: Boolean? = null,
    public var getPasslist: Boolean? = null,
    public var getProductStartEndInfo: Boolean? = null,
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    public var locL: List<HciLocation> = emptyList(),
    public var type: Type? = null
) : HciServiceRequest<HciLocGraphResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_GRAPH

    public companion object {
        public operator fun invoke(init: HciLocGraphRequest.() -> Unit): HciLocGraphRequest =
            HciLocGraphRequest().apply(init)
    }

    @Serializable
    public enum class Type {
        RT_CORRIDOR,
        RT_GRAPH,
    }
}