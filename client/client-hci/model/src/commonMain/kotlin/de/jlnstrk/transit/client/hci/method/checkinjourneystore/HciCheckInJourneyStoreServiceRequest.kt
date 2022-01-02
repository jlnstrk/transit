package de.jlnstrk.transit.client.hci.method.checkinjourneystore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciCheckInJourneyStoreServiceRequest(
  public var checkIn: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var jid: String? = null,
  public var uId: String? = null,
  public var uPos: HciCoord? = null,
  public var aLocIdx: Int? = null,
  public var dLocIdx: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciCheckInJourneyStoreServiceRequest.() -> Unit):
        HciCheckInJourneyStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.checkinjourneystore.HciCheckInJourneyStoreServiceRequest().apply(init)
  }
}
