package de.jlnstrk.transit.client.hci.method.locgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
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
public data class HciLocGeoPosServiceRequest(
  public var centerCrd: HciCoord? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var getPOIs: Boolean? = null,
  public var getStops: Boolean? = null,
  public var query: String? = null,
  public var rect: HciGeoRect? = null,
  public var ring: HciGeoRing? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var maxLoc: Int? = null,
  public var period: Int? = null,
  public var zoom: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocGeoPosServiceRequest.() -> Unit):
        HciLocGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.locgeopos.HciLocGeoPosServiceRequest().apply(init)
  }
}
