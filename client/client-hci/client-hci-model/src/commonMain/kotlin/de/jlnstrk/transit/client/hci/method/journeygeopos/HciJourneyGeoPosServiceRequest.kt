package de.jlnstrk.transit.client.hci.method.journeygeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciInOutMode
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrainPosMode
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyGeoPosServiceRequest(
  public var ageOfReport: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getSummary: Boolean? = null,
  public var getUnmatched: Boolean? = null,
  public var onlyRT: Boolean? = null,
  public var rect: HciGeoRect? = null,
  public var ring: HciGeoRing? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var locL: List<HciLocation> = emptyList(),
  public var inOut: HciInOutMode? = null,
  public var maxJny: Int? = null,
  public var perExtSize: Int? = null,
  public var perExtStep: Int? = null,
  public var perSize: Int? = null,
  public var perStep: Int? = null,
  public var rtMsgStatus: Boolean? = null,
  public var trainPosMode: HciJourneyTrainPosMode? = null,
  public var zoom: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyGeoPosServiceRequest.() -> Unit):
        HciJourneyGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeygeopos.HciJourneyGeoPosServiceRequest().apply(init)
  }
}
