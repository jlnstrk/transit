package de.jlnstrk.transit.client.hci.method.tariffsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffVia
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffSearchServiceRequest(
  public var arr: HciLocation? = null,
  public var dep: HciLocation? = null,
  public var fareGroup: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var purchaseDate: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var travelDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var travelTime: HciLocalTime? = null,
  public var trfCtx: String? = null,
  public var viaL: List<HciTariffVia> = emptyList(),
  public var singleTicket: Boolean? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciTariffSearchServiceRequest.() -> Unit):
        HciTariffSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.tariffsearch.HciTariffSearchServiceRequest().apply(init)
  }
}
