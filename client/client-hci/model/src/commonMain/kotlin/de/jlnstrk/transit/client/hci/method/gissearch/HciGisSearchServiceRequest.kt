package de.jlnstrk.transit.client.hci.method.gissearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLocPreselectionStrategy
import de.jlnstrk.transit.client.hci.model.HciRoutingPreselection
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisSearchServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var refLoc: HciLocation? = null,
  public var strategy: HciLocPreselectionStrategy? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var preselectionL: List<HciRoutingPreselection> = emptyList(),
  public var snapCoordinates: Boolean? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciGisSearchServiceRequest.() -> Unit):
        HciGisSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.gissearch.HciGisSearchServiceRequest().apply(init)
  }
}
