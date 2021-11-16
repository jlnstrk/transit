@file:UseSerializers(
    HciLocalDateSerializer::class
)

package de.jlnstrk.transit.api.hci.method.linedetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.HciLineJourneyMode
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciLineDetailsRequest(
    public var jnyDate: LocalDate? = null,
    public var jnyMode: HciLineJourneyMode? = null,
    public var lineId: String? = null,
    public var lineLoc: HciLocation? = null,
    public var pid: String? = null,
    public var reslvHimMsgs: Boolean? = null,
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLineDetailsResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LINE_DETAILS

    public companion object {
        public inline operator fun invoke(init: HciLineDetailsRequest.() -> Unit): HciLineDetailsRequest =
            HciLineDetailsRequest().apply(init)
    }
}