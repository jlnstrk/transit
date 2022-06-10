package de.jlnstrk.transit.client.hci.method.serverinfo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciGetOperatorInfo
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciServerInfoServiceRequest(
  public var getClientFilter: Boolean? = null,
  public var getConGroups: Boolean? = null,
  public var getEncoding: Boolean? = null,
  public var getEuSpiritRegions: Boolean? = null,
  public var getEventGroups: Boolean? = null,
  public var getGroupLists: Boolean? = null,
  public var getInfotext: String? = null,
  public var getMapLayerConfig: Boolean? = null,
  public var getPlanrtTS: Boolean? = null,
  public var getPoolInfo: Boolean? = null,
  public var getRegions: Boolean? = null,
  public var getReqParams: Boolean? = null,
  public var getServerDateTime: Boolean? = null,
  public var getServerInfo: Boolean? = null,
  public var getTariffInfo: Boolean? = null,
  public var getTimeTablePeriod: Boolean? = null,
  public var getVersionInfo: Boolean? = null,
  public var getJnyAttributes: List<String> = emptyList(),
  public var getProperties: List<String> = emptyList(),
  public var getRealtimeSource: List<String> = emptyList(),
  public var getOperatorInfo: HciGetOperatorInfo? = null,
) : HciServiceRequest() {
  public companion object {
    public inline operator fun invoke(`init`: HciServerInfoServiceRequest.() -> Unit):
        HciServerInfoServiceRequest =
        de.jlnstrk.transit.client.hci.method.serverinfo.HciServerInfoServiceRequest().apply(init)
  }
}
