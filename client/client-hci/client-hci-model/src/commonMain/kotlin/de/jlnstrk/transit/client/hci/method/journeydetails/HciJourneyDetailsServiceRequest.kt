package de.jlnstrk.transit.client.hci.method.journeydetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
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
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyDetailsServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var aDate: LocalDate? = null,
  public var aLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var aTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dDate: LocalDate? = null,
  public var dLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var dTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var getAltCoordinates: Boolean? = null,
  public var getAnnotations: Boolean? = null,
  public var getPasslist: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getTrainComposition: Boolean? = null,
  public var jid: String? = null,
  public var name: String? = null,
  public var polySplitting: Boolean? = null,
  public var aIdx: Int? = null,
  public var dIdx: Int? = null,
  public var trainPosMode: HciJourneyTrainPosMode? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyDetailsServiceRequest.() -> Unit):
        HciJourneyDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeydetails.HciJourneyDetailsServiceRequest().apply(init)
  }
}
