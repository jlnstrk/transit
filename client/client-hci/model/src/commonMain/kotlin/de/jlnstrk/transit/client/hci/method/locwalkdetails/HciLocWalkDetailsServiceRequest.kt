package de.jlnstrk.transit.client.hci.method.locwalkdetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocWalkDetailsServiceRequest(
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var loc: HciLocation? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocWalkDetailsServiceRequest.() -> Unit):
        HciLocWalkDetailsServiceRequest =
        de.jlnstrk.transit.client.hci.method.locwalkdetails.HciLocWalkDetailsServiceRequest().apply(init)
  }
}
