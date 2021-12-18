@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class,
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.client.hci.method.linegeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.client.hci.request.filter.HciLocationFilter
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
public class HciLineGeoPosRequest(
    public var date: LocalDate? = null,
    public var period: Duration? = null,
    public var rect: HciGeoRectangle? = null,
    public var ring: HciGeoRing? = null,
    public var time: LocalTime? = null,
    public var zoom: Int? = null,
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    public var locFltrL: List<HciLocationFilter> = emptyList(),
) : HciServiceRequest<HciLineGeoPosResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LINE_GEO_POS

    public companion object {
        public inline operator fun invoke(init: HciLineGeoPosRequest.() -> Unit): HciLineGeoPosRequest =
            HciLineGeoPosRequest().apply(init)
    }
}