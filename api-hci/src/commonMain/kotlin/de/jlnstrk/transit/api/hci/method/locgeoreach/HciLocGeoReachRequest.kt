@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.method.locgeoreach

import de.jlnstrk.transit.api.hci.model.HciReachabilityMode
import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciGisFilter
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciLocGeoReachRequest(
    public val loc: HciLocation,

    public var date: LocalDate? = null,
    public var time: LocalTime? = null,
    @Serializable(with = HciDurationSerializer::class)
    public var period: Duration? = null,
    @Serializable(with = HciMinutesSerializer::class)
    public var maxDur: Duration? = null,

    public var maxChg: Int? = null,
    public var officeGeoUnit: String? = null,
    public var step: Int? = null,
    public var mdoe: HciReachabilityMode? = null,

    public var frwd: Boolean? = null,
    public var filterEndWalks: Boolean? = null,
    public var bookingRestriction: Boolean? = null,
    public var getMapLayer: Boolean? = null,
    public var inInterval: Boolean? = null,

    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    public var gisFltrL: List<HciGisFilter> = emptyList(),
) : HciServiceRequest<HciLocGeoReachResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_GEO_REACH

    public companion object {
        public inline operator fun invoke(
            loc: HciLocation,
            init: HciLocGeoReachRequest.() -> Unit
        ): HciLocGeoReachRequest = HciLocGeoReachRequest(loc).apply(init)
    }
}