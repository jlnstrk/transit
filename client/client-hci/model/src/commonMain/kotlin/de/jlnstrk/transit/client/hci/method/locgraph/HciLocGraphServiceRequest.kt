package de.jlnstrk.transit.client.hci.method.locgraph

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLocGraphType
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocationFilter
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocGraphServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var findAequivalent: Boolean? = null,
  public var getInAndOut: Boolean? = null,
  public var getPasslist: Boolean? = null,
  public var getProductStartEndInfo: Boolean? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var locL: List<HciLocation> = emptyList(),
  public var type: HciLocGraphType? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocGraphServiceRequest.() -> Unit):
        HciLocGraphServiceRequest =
        de.jlnstrk.transit.client.hci.method.locgraph.HciLocGraphServiceRequest().apply(init)
  }
}
