@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class,
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.client.hci.method.locgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.geo.HciCoord
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
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
public data class HciLocGeoPosRequest(
    /** The center coord to query from */
    public var centerCrd: HciCoord? = null,
    /** The geographic ring to query within */
    public var ring: HciGeoRing? = null,
    /** The geographic rectangle to query within */
    public var rect: HciGeoRectangle? = null,

    /** Whether stop locations shall be returned */
    public var getStops: Boolean? = null,
    /** Whether point of interest locations shall be returned */
    public var getPOIs: Boolean? = null,
    /** Whether events shall be returned */
    public var getEvents: Boolean? = null,

    /** The maximum number of locations to be returned */
    public var maxLoc: Int? = null,
    // TODO: Usage?
    public var zoom: Int? = null,

    // TODO: Usage?
    public var date: LocalDate? = null,
    // TODO: Usage?
    public var time: LocalTime? = null,
    // TODO: Usage?
    public var period: Duration? = null,

    /** Additional filters to be applied on returned locations */
    public var locFltrL: List<HciLocationFilter> = emptyList()
) : HciServiceRequest<HciLocGeoPosResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_GEO_POS

    public companion object {
        public inline operator fun invoke(init: HciLocGeoPosRequest.() -> Unit): HciLocGeoPosRequest =
            HciLocGeoPosRequest().apply(init)
    }
}