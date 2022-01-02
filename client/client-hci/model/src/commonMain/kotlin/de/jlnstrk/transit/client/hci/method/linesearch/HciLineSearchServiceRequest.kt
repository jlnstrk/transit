package de.jlnstrk.transit.client.hci.method.linesearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLineSearchServiceRequest(
  @Serializable(with = HciLocalDateSerializer::class)
  public var date: LocalDate? = null,
  public var getStatus: Boolean? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var himPubDateB: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public var himPubDateE: LocalDate? = null,
  public var himValidToday: Boolean? = null,
  public var reqHimMsgs: Boolean? = null,
  public var reslvHimMsgs: Boolean? = null,
  public var himFltrL: List<HciHimFilter> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList()
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLineSearchServiceRequest.() -> Unit):
        HciLineSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.linesearch.HciLineSearchServiceRequest().apply(init)
  }
}
