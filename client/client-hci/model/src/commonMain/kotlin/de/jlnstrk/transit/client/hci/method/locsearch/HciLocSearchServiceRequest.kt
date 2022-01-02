package de.jlnstrk.transit.client.hci.method.locsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import de.jlnstrk.transit.client.hci.model.location.HciLocationFilter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocSearchServiceRequest(
  public var getAttributes: Boolean? = null,
  public var getInfotexts: Boolean? = null,
  public var getPOIs: Boolean? = null,
  public var getProducts: Boolean? = null,
  public var getStops: Boolean? = null,
  public var locFltrL: List<HciLocationFilter> = emptyList(),
  public var maxLoc: Int? = null,
  public var query: String? = null
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciLocSearchServiceRequest.() -> Unit):
        HciLocSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.locsearch.HciLocSearchServiceRequest().apply(init)
  }
}
