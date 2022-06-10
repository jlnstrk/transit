package de.jlnstrk.transit.client.hci.method.journeytree

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRect
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyTreeServiceRequest(
  public var getHIM: Boolean? = null,
  public var getStatus: Boolean? = null,
  public var pid: String? = null,
  public var rect: HciGeoRect? = null,
  public var ring: HciGeoRing? = null,
  public var himFltrL: List<HciHimFilter> = emptyList(),
  public var jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public var getChilds: Int? = null,
  public var getParent: Boolean? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciJourneyTreeServiceRequest.() -> Unit):
        HciJourneyTreeServiceRequest =
        de.jlnstrk.transit.client.hci.method.journeytree.HciJourneyTreeServiceRequest().apply(init)
  }
}
