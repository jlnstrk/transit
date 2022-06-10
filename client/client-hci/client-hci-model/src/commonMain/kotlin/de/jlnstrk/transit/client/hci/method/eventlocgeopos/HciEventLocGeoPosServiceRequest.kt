package de.jlnstrk.transit.client.hci.method.eventlocgeopos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Int
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciEventLocGeoPosServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var period: Int? = null,
  public var rect: HciGeoRect? = null,
  public var ring: HciGeoRing? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciEventLocGeoPosServiceRequest.() -> Unit):
        HciEventLocGeoPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.eventlocgeopos.HciEventLocGeoPosServiceRequest().apply(init)
  }
}
