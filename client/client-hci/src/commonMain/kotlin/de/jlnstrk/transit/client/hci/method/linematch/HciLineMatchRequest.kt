package de.jlnstrk.transit.client.hci.method.linematch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLineMatchRequest(
    public val input: String,
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLineMatchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LINE_MATCH

    public companion object {
        public inline operator fun invoke(input: String, init: HciLineMatchRequest.() -> Unit): HciLineMatchRequest =
            HciLineMatchRequest(input).apply(init)
    }
}