package de.jlnstrk.transit.client.hci.method.bookingassortment

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingAssortmentServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var flags: String? = null,
  public var supplier: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciBookingAssortmentServiceRequest.() -> Unit):
        HciBookingAssortmentServiceRequest =
        de.jlnstrk.transit.client.hci.method.bookingassortment.HciBookingAssortmentServiceRequest().apply(init)
  }
}
