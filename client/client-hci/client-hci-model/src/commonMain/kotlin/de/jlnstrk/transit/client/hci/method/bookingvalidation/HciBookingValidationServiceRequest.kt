package de.jlnstrk.transit.client.hci.method.bookingvalidation

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.booking.HciBookingResult
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingValidationServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var obj: HciBookingResult? = null,
  public var path: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciBookingValidationServiceRequest.() -> Unit):
        HciBookingValidationServiceRequest =
        de.jlnstrk.transit.client.hci.method.bookingvalidation.HciBookingValidationServiceRequest().apply(init)
  }
}
