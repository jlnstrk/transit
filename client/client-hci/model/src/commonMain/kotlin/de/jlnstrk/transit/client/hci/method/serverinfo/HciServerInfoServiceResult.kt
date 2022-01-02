package de.jlnstrk.transit.client.hci.method.serverinfo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciEuSpiritRegion
import de.jlnstrk.transit.client.hci.model.HciGroupInfo
import de.jlnstrk.transit.client.hci.model.HciMapConfig
import de.jlnstrk.transit.client.hci.model.HciOperator
import de.jlnstrk.transit.client.hci.model.HciPlandataEncoding
import de.jlnstrk.transit.client.hci.model.HciPoolInfo
import de.jlnstrk.transit.client.hci.model.HciPropertyPair
import de.jlnstrk.transit.client.hci.model.HciRealtimeDataSource
import de.jlnstrk.transit.client.hci.model.HciRegion
import de.jlnstrk.transit.client.hci.model.HciRequestParameterGroup
import de.jlnstrk.transit.client.hci.model.HciServerInformation
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.connection.HciConnectionScoreGroupSettings
import de.jlnstrk.transit.client.hci.model.event.HciEventGroup
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciServerInfoServiceResult(
  public val clientVersion: String? = null,
  public val common: HciCommon? = null,
  public val conGrpSettings: HciConnectionScoreGroupSettings? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val groupL: HciGroupInfo? = null,
  public val hciVersion: String? = null,
  public val planrtTS: String? = null,
  public val sD: String? = null,
  public val sT: String? = null,
  public val serverInfo: HciServerInformation? = null,
  public val serverVersion: String? = null,
  public val cFltrRefL: List<Int> = emptyList(),
  public val euspRegL: List<HciEuSpiritRegion> = emptyList(),
  public val eventGroupL: List<HciEventGroup> = emptyList(),
  public val it: List<String> = emptyList(),
  public val jnyRemarkL: List<Int> = emptyList(),
  public val mapLayerConfL: List<HciMapConfig> = emptyList(),
  public val opL: List<HciOperator> = emptyList(),
  public val poolInfoL: List<HciPoolInfo> = emptyList(),
  public val propL: List<HciPropertyPair> = emptyList(),
  public val regL: List<HciRegion> = emptyList(),
  public val reqParamGrpL: List<HciRequestParameterGroup> = emptyList(),
  public val rtSources: List<HciRealtimeDataSource> = emptyList(),
  public val enc: HciPlandataEncoding = HciPlandataEncoding.UNKNOWN
) : HciServiceResult()
