package de.jlnstrk.transit.client.hci.method.bookingdata

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciBookingDataServiceRequest(
  public var cid: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var newDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var newTime: HciLocalTime? = null,
  public var `param`: String? = null,
  public var rid: String? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciBookingDataServiceRequest.() -> Unit):
        HciBookingDataServiceRequest =
        de.jlnstrk.transit.client.hci.method.bookingdata.HciBookingDataServiceRequest().apply(init)
  }
}
