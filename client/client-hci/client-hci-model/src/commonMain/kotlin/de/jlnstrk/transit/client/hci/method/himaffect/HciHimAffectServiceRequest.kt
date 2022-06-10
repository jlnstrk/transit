package de.jlnstrk.transit.client.hci.method.himaffect

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimAffectServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateE: LocalDate? = null,
  public var himId: String? = null,
  public var maxDist: Int? = null,
  public var maxDur: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeB: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeE: HciLocalTime? = null,
  public var dirLocL: List<HciLocation> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var maxChg: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciHimAffectServiceRequest.() -> Unit):
        HciHimAffectServiceRequest =
        de.jlnstrk.transit.client.hci.method.himaffect.HciHimAffectServiceRequest().apply(init)
  }
}
