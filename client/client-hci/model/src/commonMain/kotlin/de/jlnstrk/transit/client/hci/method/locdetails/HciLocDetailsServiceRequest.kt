package de.jlnstrk.transit.client.hci.method.locdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocDetailsServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var getAttributes: Boolean? = null,
  public var getEvents: Boolean? = null,
  public var getHIM: Boolean? = null,
  public var getIcons: Boolean? = null,
  public var getInfoGrids: Boolean? = null,
  public var getInfotexts: Boolean? = null,
  public var getProducts: Boolean? = null,
  public var getRoutes: Boolean? = null,
  public var getTariff: Boolean? = null,
  public var getWeatherInfo: Boolean? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var trfReq: HciTariffRequest? = null,
  public var locL: List<HciLocation> = emptyList(),
  public var period: Int? = null,
  public var zoom: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocDetailsServiceRequest.() -> Unit):
        HciLocDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.locdetails.HciLocDetailsServiceRequest().apply(init)
  }
}
