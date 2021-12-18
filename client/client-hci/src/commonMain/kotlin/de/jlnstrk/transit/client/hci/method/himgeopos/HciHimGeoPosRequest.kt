@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class,
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.client.hci.method.himgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciHimFilter
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciHimGeoPosRequest(
    public var dateB: LocalDate? = null,
    public var dateE: LocalDate? = null,
    public var dur: Duration? = null,
    public var getPolyLine: Boolean? = null,
    public var maxNum: Int? = null,
    public var onlyHimId: Boolean? = null,
    public var polyLineRes: Int? = null,
    public var prio: Int? = null,
    public var rect: HciGeoRectangle? = null,
    public var timeB: LocalTime? = null,
    public var timeE: LocalTime? = null,
    public var himFltrL: List<HciHimFilter> = emptyList(),
) : HciServiceRequest<HciHimGeoPosResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.HIM_GEO_POS

    public companion object {
        public inline operator fun invoke(init: HciHimGeoPosRequest.() -> Unit): HciHimGeoPosRequest =
            HciHimGeoPosRequest().apply(init)
    }
}