package de.jlnstrk.transit.api.hci.method.locdetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.tariff.HciTariffRequest
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciLocDetailsRequest(
    public var date: String? = null,
    public val getAttributes: Boolean? = null,
    public val getEvents: Boolean? = null,
    public val getHIM: Boolean? = null,
    public val getIcons: Boolean? = null,
    public val getInfoGrids: Boolean? = null,
    public val getInfotexts: Boolean? = null,
    public val getProducts: Boolean? = null,
    public val getRoutes: Boolean? = null,
    public val getTariff: Boolean? = null,
    public val getWeatherInfo: Boolean? = null,
    public val locL: List<HciLocation> = emptyList(),
    public val time: String? = null,
    public val trfReq: HciTariffRequest? = null,
    public val zoom: Int? = null,
) : HciServiceRequest<HciLocDetailsResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_DETAILS

    public companion object {
        public inline operator fun invoke(init: HciLocDetailsRequest.() -> Unit): HciLocDetailsRequest =
            HciLocDetailsRequest().apply(init)
    }
}