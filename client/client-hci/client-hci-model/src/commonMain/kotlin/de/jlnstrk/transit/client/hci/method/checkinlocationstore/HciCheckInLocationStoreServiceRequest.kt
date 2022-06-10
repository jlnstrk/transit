package de.jlnstrk.transit.client.hci.method.checkinlocationstore

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciCheckInLocationStoreServiceRequest(
  public var checkIn: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var lid: String? = null,
  public var uId: String? = null,
  public var uPos: HciCoord? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciCheckInLocationStoreServiceRequest.() -> Unit):
        HciCheckInLocationStoreServiceRequest =
        de.jlnstrk.transit.client.hci.method.checkinlocationstore.HciCheckInLocationStoreServiceRequest().apply(init)
  }
}
