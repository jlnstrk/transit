package de.jlnstrk.transit.client.hci.method.himgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimGeoPosServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var dateE: LocalDate? = null,
  public var getPolyLine: Boolean? = null,
  public var onlyHimId: Boolean? = null,
  public var rect: HciGeoRect? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeB: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var timeE: HciLocalTime? = null,
  public var himFltrL: List<HciHimFilter> = emptyList(),
  public var dur: Int? = null,
  public var maxNum: Int? = null,
  public var polyLineRes: Int? = null,
  public var prio: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciHimGeoPosServiceRequest.() -> Unit):
        HciHimGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.himgeopos.HciHimGeoPosServiceRequest().apply(init)
  }
}
