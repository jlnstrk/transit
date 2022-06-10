package de.jlnstrk.transit.client.hci.method.locgeoreach

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciReachabilityMode
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.gis.HciGisFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocGeoReachServiceRequest(
  public var bookingRestriction: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var filterEndWalks: Boolean? = null,
  public var frwd: Boolean? = null,
  public var getMapLayer: Boolean? = null,
  public var inInterval: Boolean? = null,
  public var loc: HciLocation? = null,
  public var officeGeoUnit: String? = null,
  public var step: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
  public var gisFltrL: List<HciGisFilter> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var maxChg: Int? = null,
  public var maxDur: Int? = null,
  public var mode: HciReachabilityMode? = null,
  public var period: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocGeoReachServiceRequest.() -> Unit):
        HciLocGeoReachServiceRequest =
        de.jlnstrk.transit.client.hci.method.locgeoreach.HciLocGeoReachServiceRequest().apply(init)
  }
}
