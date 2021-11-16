package de.jlnstrk.transit.api.hci.method.locwalkdetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocWalkDetailsRequest(
    public val loc: HciLocation,
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciLocWalkDetailsResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_WALK_DETAILS

    public companion object {
        public inline operator fun invoke(
            loc: HciLocation,
            init: HciLocWalkDetailsRequest.() -> Unit
        ): HciLocWalkDetailsRequest =
            HciLocWalkDetailsRequest(loc).apply(init)
    }
}