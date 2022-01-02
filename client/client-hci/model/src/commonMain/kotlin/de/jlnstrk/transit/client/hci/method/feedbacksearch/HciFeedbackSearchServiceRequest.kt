package de.jlnstrk.transit.client.hci.method.feedbacksearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocationFilter
import de.jlnstrk.transit.client.hci.model.user.HciUserRole
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFeedbackSearchServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var period: Int? = null,
  public var rcvRole: HciUserRole? = null,
  public var rcvUId: String? = null,
  public var rect: HciGeoRect? = null,
  public var text: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var uId: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciFeedbackSearchServiceRequest.() -> Unit):
        HciFeedbackSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.feedbacksearch.HciFeedbackSearchServiceRequest().apply(init)
  }
}
