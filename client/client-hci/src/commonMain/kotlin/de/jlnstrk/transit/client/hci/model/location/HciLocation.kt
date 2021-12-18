@file:UseSerializers(
    HciDurationSerializer::class,
    HciZoneOffsetSerializer::class
)

package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciGrid
import de.jlnstrk.transit.client.hci.model.HciText
import de.jlnstrk.transit.client.hci.model.HciUser
import de.jlnstrk.transit.client.hci.model.HciWeatherInformation
import de.jlnstrk.transit.client.hci.model.geo.HciCoord
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffReference
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffResult
import de.jlnstrk.transit.client.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciZoneOffsetSerializer
import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.ZoneOffset
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public open class HciLocation(
    public val type: Type? = null,
    public val name: String? = null,
    public val lid: String? = null,
    public val crd: HciCoord? = null,
    public val icoX: Int? = null,
    public val state: State? = null,
    public var msgL: List<HciMessage> = emptyList(),
    public val dist: Int? = null,
    public val dur: Int? = null,
    public val altNameL: List<String> = emptyList(),
    public val childLocL: List<HciLocation> = emptyList(),
    public val defName: String? = null,
    public val descr: String? = null,
    public val dirRefL: List<Int> = emptyList(),
    public val eteId: String? = null,
    public val gridL: List<HciGrid> = emptyList(),
    public val isFavrbl: Boolean? = null,
    public val isPref: Boolean? = null,
    public val isRoutable: Boolean? = null,
    public val isSelectable: Boolean? = null,
    public val matchValue: Int? = null,
    public val mcpData: HciLocationMcpData? = null,
    public val nameFormatted: HciText? = null,
    public val nameAlt: String? = null,
    public val ovwTrfRefL: List<HciTariffReference> = emptyList(),
    public val pSERefl: List<Int> = emptyList(),
    public val poolId: String? = null,
    public val prvX: Int? = null,
    public val rRefL: List<Int> = emptyList(),
    public val routeL: List<HciLocationRoute> = emptyList(),
    public val stopLocL: List<Int> = emptyList(),
    public val trfRes: HciTariffResult? = null,
    public val userL: List<HciUser> = emptyList(),
    public val extId: Long? = null,
    public val pCls: Int? = null,
    public val pRefL: List<Int> = emptyList(),
    public val entryLocL: List<Int> = emptyList(),
    public val wt: Int? = null,
    public val meta: Boolean? = null,
    public val isMainMast: Boolean? = null,
    public val mMastLocX: Int? = null,
    public val entry: Boolean? = null,
    public val gidL: List<String> = emptyList(),
    public val chgTime: Duration? = null,
    public val TZOffset: ZoneOffset? = null,
    public val vm: ViewMode? = null,
    public val weatherInfos: List<HciWeatherInformation> = emptyList(),
) {

    @Serializable // (with = HciLocationTypeSerializer::class)
    public enum class Type {
        ALL,

        @SerialName("S")
        STATION,

        @SerialName("SA")
        STATION_ADDRESS,

        @SerialName("SP")
        STATION_POI,

        @SerialName("A")
        ADDRESS,

        @SerialName("AP")
        ADDRESS_POI,

        @SerialName("P")
        POI,

        @SerialName("C")
        COORD,

        @SerialName("HL")
        HAILING_POINT,
        MCP,
    }

    @Serializable
    public enum class State {
        // TODO: Meaning?
        F,

        // TODO: Meaning?
        M
    }

    @Serializable
    public enum class ViewMode {
        // TODO: Meaning?
        LI,

        // TODO: Meaning?
        LO,

        // TODO: Meaning?
        NI,

        // TODO: Meaning?
        PO,

        // TODO: Meaning?
        SB,

        // TODO: Meaning?
        SI,

        // TODO: Meaning?
        TI,
    }
}

