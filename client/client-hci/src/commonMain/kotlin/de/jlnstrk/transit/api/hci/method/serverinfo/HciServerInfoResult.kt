package de.jlnstrk.transit.api.hci.method.serverinfo

import de.jlnstrk.transit.api.hci.model.HciEventGroup
import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.*
import de.jlnstrk.transit.api.hci.model.connection.HciConnectionScoreGroupSettings
import de.jlnstrk.transit.api.hci.response.HciTimeAwareResponse
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciServerInfoResult(
    public val clientVersion: String?,
    public val serverVersion: String?,
    public val hciVersion: String?,
    public val enc: HciPlanDataEncoding?,
    public val groupL: HciGroupInfo?,
    public val conGrpSettings: HciConnectionScoreGroupSettings?,
    public val euspRegL: List<HciEuSpiritRegion> = emptyList(),
    public val eventGroupL: List<HciEventGroup> = emptyList(),
    public val it: List<String> = emptyList(),
    public val jnyRemarkL: List<Int> = emptyList(),
    public val mapLayerConfL: List<HciMapConfig> = emptyList(),
    public val opL: List<HciOperator> = emptyList(),
    public val poolInfoL: List<HciPoolInfo> = emptyList(),
    public val propL: List<HciPair> = emptyList(),
    public val regL: List<HciRegion> = emptyList(),
    public val reqParamGrpL: List<HciRequestParameterGroup> = emptyList(),
    public val rtSources: List<HciRtSource> = emptyList(),
) : HciTimeAwareResponse()