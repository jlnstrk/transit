@file:UseSerializers(
    HciLocalDateSerializer::class
)

package de.jlnstrk.transit.client.hci.method.linesearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciHimFilter
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciLineSearchRequest(
    public var date: LocalDate? = null,
    public var getStatus: Boolean? = null,
    public var himPubDateB: LocalDate? = null,
    public var himPubDateE: LocalDate? = null,
    public var himValidToday: Boolean? = null,
    public var reqHimMsgs: Boolean? = null,
    public var reslvHimMsgs: Boolean? = null,
    public var himFltrL: List<HciHimFilter> = emptyList(),
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLineSearchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LINE_SEARCH

    public companion object {
        public inline operator fun invoke(init: HciLineSearchRequest.() -> Unit): HciLineSearchRequest =
            HciLineSearchRequest().apply(init)
    }
}