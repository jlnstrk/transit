package de.jlnstrk.transit.client.hci.method.journeytrackmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrackMatchAlgorithm
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrackPoint
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyTrackSectionData
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTrackMatchServiceRequest(
  public var jnyTrkPtL: List<HciJourneyTrackPoint> = emptyList(),
  public var secDataL: List<HciJourneyTrackSectionData> = emptyList(),
  public var algorithm: HciJourneyTrackMatchAlgorithm? = null,
  public var calcMatchQuality: Boolean? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyTrackMatchServiceRequest.() -> Unit):
        HciJourneyTrackMatchServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeytrackmatch.HciJourneyTrackMatchServiceRequest().apply(init)
  }
}
