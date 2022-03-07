package de.jlnstrk.transit.client.hci.method.journeycourse

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciDirectionType
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrainPosMode
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyCourseServiceRequest(
  public var arrLoc: HciLocation? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var depLoc: HciLocation? = null,
  public var getEdgeAni: Boolean? = null,
  public var getEdgeCourse: Boolean? = null,
  public var getIST: Boolean? = null,
  public var getMainAni: Boolean? = null,
  public var getMainCourse: Boolean? = null,
  public var getPassLoc: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var jid: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var dir: HciDirectionType? = null,
  public var perSize: Int? = null,
  public var perStep: Int? = null,
  public var trainPosMode: HciJourneyTrainPosMode? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyCourseServiceRequest.() -> Unit):
        HciJourneyCourseServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeycourse.HciJourneyCourseServiceRequest().apply(init)
  }
}
