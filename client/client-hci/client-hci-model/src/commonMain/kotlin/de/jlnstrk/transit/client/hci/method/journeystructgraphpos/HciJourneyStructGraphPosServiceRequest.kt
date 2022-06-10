package de.jlnstrk.transit.client.hci.method.journeystructgraphpos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrainPosMode
import de.jlnstrk.transit.client.hci.model.struct.HciStructGraphInputReference
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyStructGraphPosServiceRequest(
  public var input: HciStructGraphInputReference? = null,
  public var intervalSize: Int? = null,
  public var intervalStep: Int? = null,
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var trainPosMode: HciJourneyTrainPosMode? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyStructGraphPosServiceRequest.() -> Unit):
        HciJourneyStructGraphPosServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeystructgraphpos.HciJourneyStructGraphPosServiceRequest().apply(init)
  }
}
