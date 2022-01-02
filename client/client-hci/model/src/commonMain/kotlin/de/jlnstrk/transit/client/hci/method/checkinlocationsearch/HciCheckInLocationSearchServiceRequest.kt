package de.jlnstrk.transit.client.hci.method.checkinlocationsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
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
public data class HciCheckInLocationSearchServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var rect: HciGeoRect? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var uId: String? = null,
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var checkIn: Boolean? = null,
  public var period: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciCheckInLocationSearchServiceRequest.() -> Unit):
        HciCheckInLocationSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.checkinlocationsearch.HciCheckInLocationSearchServiceRequest().apply(init)
  }
}
