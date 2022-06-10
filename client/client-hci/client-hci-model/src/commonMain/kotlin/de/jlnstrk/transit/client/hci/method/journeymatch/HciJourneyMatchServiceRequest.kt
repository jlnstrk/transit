package de.jlnstrk.transit.client.hci.method.journeymatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyMatchCombineMode
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyMatchServiceRequest(
  public var clustering: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateE: LocalDate? = null,
  public var directions: String? = null,
  public var extId: String? = null,
  public var getLineXml: Boolean? = null,
  public var input: String? = null,
  public var matchLine: Boolean? = null,
  public var maxJourneys: Int? = null,
  public var onlyCR: Boolean? = null,
  public var onlyRT: Boolean? = null,
  public var onlyTN: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeB: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeE: HciLocalTime? = null,
  public var tripId: String? = null,
  public var useAeqi: Boolean? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var combineMode: HciJourneyMatchCombineMode? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyMatchServiceRequest.() -> Unit):
        HciJourneyMatchServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeymatch.HciJourneyMatchServiceRequest().apply(init)
  }
}
