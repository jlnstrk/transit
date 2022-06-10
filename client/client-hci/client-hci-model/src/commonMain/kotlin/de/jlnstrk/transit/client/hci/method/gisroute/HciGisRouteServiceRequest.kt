package de.jlnstrk.transit.client.hci.method.gisroute

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.gis.HciGisFilter
import de.jlnstrk.transit.client.hci.model.gis.HciGisRouteMode
import de.jlnstrk.transit.client.hci.model.gis.HciGisType
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGisRouteServiceRequest(
  public var arrLoc: HciLocation? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var depLoc: HciLocation? = null,
  public var frwd: Boolean? = null,
  public var getDescription: Boolean? = null,
  public var getEco: Boolean? = null,
  public var getPolyline: Boolean? = null,
  public var gisCtx: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var gisFltrL: List<HciGisFilter> = emptyList(),
  public var getTrafficMsg: Boolean? = null,
  public var mode: HciGisRouteMode? = null,
  public var type: HciGisType? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciGisRouteServiceRequest.() -> Unit):
        HciGisRouteServiceRequest =
        de.jlnstrk.transit.client.hci.method.gisroute.HciGisRouteServiceRequest().apply(init)
  }
}
