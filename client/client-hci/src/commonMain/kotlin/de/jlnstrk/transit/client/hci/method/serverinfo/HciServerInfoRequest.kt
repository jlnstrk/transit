package de.jlnstrk.transit.client.hci.method.serverinfo

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import de.jlnstrk.transit.client.hci.request.HciServiceRequest
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciServerInfoRequest(
    private var getConGroups: Boolean? = null,
    private var getEncoding: Boolean? = null,
    private var getEuSpiritRegions: Boolean? = null,
    private var getEventGroups: Boolean? = null,
    private var getGroupLists: Boolean? = null,
    private var getInfotext: String? = null,
    private var getJnyAttributes: List<String> = emptyList(),
    private var getMapLayerConfig: Boolean? = null,
    private var getOperatorInfo: GetOperatorInfo? = null,
    private var getPlanrtTS: Boolean? = null,
    private var getPoolInfo: Boolean? = null,
    private var getProperties: List<String> = emptyList(),
    private var getRealtimeSource: List<String> = emptyList(),
    private var getRegions: Boolean? = null,
    private var getReqParams: Boolean? = null,
    private var getServerDateTime: Boolean? = null,
    private var getTimeTablePeriod: Boolean? = null,
    private var getVersionInfo: Boolean? = null,
) : HciServiceRequest<HciServerInfoResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.SERVER_INFO

    public companion object {
        public inline operator fun invoke(init: HciServerInfoRequest.() -> Unit): HciServerInfoRequest =
            HciServerInfoRequest().apply(init)
    }

    @HciModel("1.39")
    @Serializable
    public enum class GetOperatorInfo {
        BASIC,
        INCLUDE_ADMIN,
        NONE,
    }
}