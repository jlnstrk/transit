@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.method.journeycourse

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciDirection
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrainPositionMode
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciJourneyCourseRequest(
    public var depLoc: HciLocation? = null,
    public var arrLoc: HciLocation? = null,
    public var dir: HciDirection.Type? = null,
    public var date: LocalDate? = null,
    public var time: LocalTime? = null,

    public var getEdgeAni: Boolean? = null,
    public var getEdgeCourse: Boolean? = null,
    public var getIST: Boolean? = null,
    public var getMainAni: Boolean? = null,
    public var getMainCourse: Boolean? = null,
    public var getPassLoc: Boolean? = null,
    public var getPolyline: Boolean? = null,

    /** The id of the journey to get the course of */
    public var jid: String? = null,

    /** Additional filters to be applied on the returned journeys */
    public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
    public var perSize: Int? = null,
    public var perStep: Int? = null,
    public var trainPosMode: HciJourneyTrainPositionMode? = null
) : HciServiceRequest<HciJourneyCourseResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.JOURNEY_COURSE

    public companion object {
        public inline operator fun invoke(init: HciJourneyCourseRequest.() -> Unit): HciJourneyCourseRequest =
            HciJourneyCourseRequest().apply(init)
    }
}