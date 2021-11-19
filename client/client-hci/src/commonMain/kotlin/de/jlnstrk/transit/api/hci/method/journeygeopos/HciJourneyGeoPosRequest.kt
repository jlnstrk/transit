@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.method.journeygeopos

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.HciInOutMode
import de.jlnstrk.transit.api.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.api.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.api.hci.model.journey.HciJourneyTrainPositionMode
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciJourneyGeoPosRequest(
    /** The geographic ring to query within */
    public var ring: HciGeoRing? = null,

    /** The geographic rectangle to query within */
    public var rect: HciGeoRectangle? = null,

    /** The date to calculate journey positions for */
    public var date: LocalDate? = null,

    /** The time to calculate journey positions for */
    public var time: LocalTime? = null,

    // TODO: Purpose?
    public var ageOfReport: Boolean? = null,

    // TODO: Purpose?
    public var perExtSize: Int? = null,

    // TODO: Purpose?
    public var perExtStep: Int? = null,

    // TODO: Purpose?
    public var perSize: Int? = null,

    // TODO: Purpose?
    public var perStep: Int? = null,

    // TODO: Purpose?
    public var getSummary: Boolean? = null,

    // TODO: Purpose?
    public var getUnmatched: Boolean? = null,

    /** The maximum number of journeys to be returned */
    public var maxJny: Int? = null,

    /** Whether only realtime journeys shall be returned */
    public var onlyRT: Boolean? = null,

    // TODO: Purpose?
    public var rtMsgStatus: Boolean? = null,

    // TODO: Domain?
    public var zoom: Int? = null,

    /** Whether simple train compositions shall be returned */
    public var getSimpleTrainComposition: Boolean? = null,

    // TODO: Purpose?
    public var inOut: HciInOutMode? = null,

    /** The train position mode */
    public var trainPosMode: HciJourneyTrainPositionMode? = null,

    // TODO: Purpose?
    public var locL: List<HciLocation> = emptyList(),

    /** Additional filters to be applied on the returned journeys */
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest<HciJourneyGeoPosResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.JOURNEY_GEO_POS

    public companion object {
        public inline operator fun invoke(block: HciJourneyGeoPosRequest.() -> Unit): HciJourneyGeoPosRequest =
            HciJourneyGeoPosRequest().apply(block)
    }
}