package de.jlnstrk.transit.client.hci.method.sharelocation

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.share.HciShareLocationAction
import de.jlnstrk.transit.client.hci.model.share.HciShareMail
import de.jlnstrk.transit.client.hci.model.share.HciShareMode
import de.jlnstrk.transit.client.hci.model.share.HciShareSMS
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciShareLocationServiceRequest(
  public var act: HciShareLocationAction? = null,
  public var captchaToken: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var frwd: Boolean? = null,
  public var loc: HciLocation? = null,
  public var mail: HciShareMail? = null,
  public var mode: HciShareMode? = null,
  public var sms: HciShareSMS? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public var time: HciLocalTime? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciShareLocationServiceRequest.() -> Unit):
        HciShareLocationServiceRequest =
        de.jlnstrk.transit.client.hci.method.sharelocation.HciShareLocationServiceRequest().apply(init)
  }
}
