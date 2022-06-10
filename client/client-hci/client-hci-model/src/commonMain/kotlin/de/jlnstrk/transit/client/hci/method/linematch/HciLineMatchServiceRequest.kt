package de.jlnstrk.transit.client.hci.method.linematch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLineMatchServiceRequest(
  public var input: String? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLineMatchServiceRequest.() -> Unit):
        HciLineMatchServiceRequest =
        de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchServiceRequest().apply(init)
  }
}
