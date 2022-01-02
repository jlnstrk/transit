package de.jlnstrk.transit.client.hci.method.linedetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciLineJourneyMode
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLineDetailsServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var jnyDate: LocalDate? = null,
  public var lineId: String? = null,
  public var lineLoc: HciLocation? = null,
  public var pid: String? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var jnyMode: HciLineJourneyMode? = null,
  public var reslvHimMsgs: Boolean? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLineDetailsServiceRequest.() -> Unit):
        HciLineDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.linedetails.HciLineDetailsServiceRequest().apply(init)
  }
}
