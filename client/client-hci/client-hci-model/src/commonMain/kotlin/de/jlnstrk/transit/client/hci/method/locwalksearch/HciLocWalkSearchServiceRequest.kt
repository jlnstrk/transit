package de.jlnstrk.transit.client.hci.method.locwalksearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocWalkSearchServiceRequest(
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocWalkSearchServiceRequest.() -> Unit):
        HciLocWalkSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.locwalksearch.HciLocWalkSearchServiceRequest().apply(init)
  }
}
