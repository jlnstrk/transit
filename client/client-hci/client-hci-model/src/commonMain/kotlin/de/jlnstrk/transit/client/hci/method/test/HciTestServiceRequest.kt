package de.jlnstrk.transit.client.hci.method.test

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTestServiceRequest(
  public var inBool: Boolean? = null,
  public var input: String? = null,
  public var inputBool: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var inDate: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var inDateTime: LocalDate? = null,
  public var inFloat: Double? = null,
  public var inInt: Int? = null,
  public var inLong: Int? = null,
  public var inStr: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var inTime: HciLocalTime? = null,
  public var inputFloat: Double? = null,
  public var inputInt: Int? = null,
  public var inputLong: Int? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciTestServiceRequest.() -> Unit):
        HciTestServiceRequest =
        de.jlnstrk.transit.client.hci.method.test.HciTestServiceRequest().apply(init)
  }
}
