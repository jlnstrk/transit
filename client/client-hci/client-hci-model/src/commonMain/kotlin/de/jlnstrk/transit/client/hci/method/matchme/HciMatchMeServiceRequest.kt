package de.jlnstrk.transit.client.hci.method.matchme

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.HciTracePoint
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciMatchMeServiceRequest(
  public var devId: String? = null,
  public var dir: String? = null,
  public var jid: String? = null,
  public var locEntry: HciLocation? = null,
  public var locExit: HciLocation? = null,
  public var search: String? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var tracePtL: List<HciTracePoint> = emptyList(),
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciMatchMeServiceRequest.() -> Unit):
        HciMatchMeServiceRequest =
        de.jlnstrk.transit.client.hci.method.matchme.HciMatchMeServiceRequest().apply(init)
  }
}
