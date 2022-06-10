package de.jlnstrk.transit.client.hci.method.onefieldsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciOneFieldSearchRequestType
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciOneFieldSearchServiceRequest(
  public var input: String? = null,
  public var pos: HciCoord? = null,
  public var type: List<HciOneFieldSearchRequestType> = emptyList(),
  public var ignoreLang: Boolean? = null,
  public var maxLoc: Int? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciOneFieldSearchServiceRequest.() -> Unit):
        HciOneFieldSearchServiceRequest =
        de.jlnstrk.transit.client.hci.method.onefieldsearch.HciOneFieldSearchServiceRequest().apply(init)
  }
}
