@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.method.journeydetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciJourneyDetailsRequest(
    /** The id of the journey to get details of */
    public var jid: String? = null,

    /** The departure location on the journey. Trims the preceding stops */
    public var dLoc: HciLocation? = null,

    /** The departure index on the journey. Trims the preceding stops */
    public var dIdx: Int? = null,

    // TODO: Does this trim stops approached earlier than this date?
    public var dDate: LocalDate? = null,

    // TODO: Does this trim stops approached earlier than this time?
    public var dTime: LocalTime? = null,

    /** The arrival location on the journey. Trims the succeeding stops */
    public var aLoc: HciLocation? = null,

    /** The arrival index on the journey. Trims the succeeding stops */
    public var aIdx: Int? = null,

    // TODO: Does this trim stops approached later than this date?
    public var aDate: LocalDate? = null,

    // TODO: Does this trim stops approached later than this time?
    public var aTime: LocalTime? = null,

    /** Explicitly specifies the regard journey date */
    public var date: LocalDate? = null,

    // TODO: Purpose?
    public var name: String? = null,

    // TODO: Purpose?
    public var getAltCoordinates: Boolean? = null,

    /** Whether annotations shall be returned */
    public var getAnnotations: Boolean? = null,

    /** Whether passed stops shall be returned */
    public var getPasslist: Boolean? = null,

    /** Whether the path polyline shall be returned */
    public var getPolyline: Boolean? = null,

    /** Whether the simple train composition shall be returned */
    public var getSimpleTrainComposition: Boolean? = null,

    /** Whether the train composition shall be returned */
    public var getTrainComposition: Boolean? = null,

    // TODO: What is the effect of this?
    /** Whether returned polylines shall be split */
    public var polySplitting: Boolean? = null
) : HciServiceRequest<HciJourneyDetailsResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.JOURNEY_DETAILS

    public companion object {
        public inline operator fun invoke(init: HciJourneyDetailsRequest.() -> Unit): HciJourneyDetailsRequest =
            HciJourneyDetailsRequest().apply(init)
    }
}