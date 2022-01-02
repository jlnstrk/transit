package de.jlnstrk.transit.client.hci.method.stationboard

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciPasslistMode
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.HciStationBoardGroupMode
import de.jlnstrk.transit.client.hci.model.HciStationBoardSortType
import de.jlnstrk.transit.client.hci.model.HciStationBoardType
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocationFilter
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
public data class HciStationBoardServiceRequest(
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var aTimeS: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var dTimeS: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateE: LocalDate? = null,
  public var dirLoc: HciLocation? = null,
  public var getSimpleTrainComposition: Boolean? = null,
  public var getTrainComposition: Boolean? = null,
  public var jid: String? = null,
  public var per: Boolean? = null,
  public var qrCode: String? = null,
  public var stbLoc: HciLocation? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var impLocL: List<HciLocation> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var dur: Int? = null,
  public var getJnySameTime: Boolean? = null,
  public var grpMode: HciStationBoardGroupMode? = null,
  public var maxJny: Int? = null,
  public var minDur: Int? = null,
  public var pslMaxStops: Int? = null,
  public var pslMode: HciPasslistMode? = null,
  public var sort: HciStationBoardSortType? = null,
  public var type: HciStationBoardType? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciStationBoardServiceRequest.() -> Unit):
        HciStationBoardServiceRequest =
        de.jlnstrk.transit.client.hci.method.stationboard.HciStationBoardServiceRequest().apply(init)
  }
}
