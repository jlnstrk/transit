package de.jlnstrk.transit.client.hci.method.himdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimDetailsServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var endDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var endTime: HciLocalTime? = null,
  public var getPolyLine: Boolean? = null,
  public var getTrains: Boolean? = null,
  public var input: String? = null,
  public var polyLineRes: Int? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciHimDetailsServiceRequest.() -> Unit):
        HciHimDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.himdetails.HciHimDetailsServiceRequest().apply(init)
  }
}
