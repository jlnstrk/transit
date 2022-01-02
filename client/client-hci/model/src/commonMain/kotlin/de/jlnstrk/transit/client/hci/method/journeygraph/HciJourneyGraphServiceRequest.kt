package de.jlnstrk.transit.client.hci.method.journeygraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyGraphServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var getPasslist: Boolean? = null,
  public var getProductStartEndInfo: Boolean? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyGraphServiceRequest.() -> Unit):
        HciJourneyGraphServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeygraph.HciJourneyGraphServiceRequest().apply(init)
  }
}
