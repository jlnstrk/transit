package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import de.jlnstrk.transit.client.hci.model.HciGrid
import de.jlnstrk.transit.client.hci.model.HciWeatherInformation
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffRef
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffResult
import de.jlnstrk.transit.client.hci.model.text.HciText
import de.jlnstrk.transit.client.hci.model.user.HciUser
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.serializer.HciUtcOffsetSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocation(
  @Serializable(with = HciUtcOffsetSerializer::class)
  public val TZOffset: UtcOffset? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val chgTime: HciLocalTime? = null,
  public val crd: HciCoord? = null,
  public val defName: String? = null,
  public val descr: String? = null,
  public val dist: Int? = null,
  public val entry: Boolean = false,
  public val eteId: String? = null,
  public val extId: String? = null,
  public val icoX: Int? = null,
  public val isFavrbl: Boolean = true,
  public val isHstrbl: Boolean = true,
  public val isMainMast: Boolean = false,
  public val isPref: Boolean = false,
  public val isRoutable: Boolean = true,
  public val isSelectable: Boolean = true,
  public val lid: String? = null,
  public val mMastLocX: Int? = null,
  public val matchValue: Int? = null,
  public val mcpData: HciLocationMCPData? = null,
  public val meta: Boolean = false,
  public val name: String? = null,
  public val nameAlt: String? = null,
  public val nameFormatted: HciText? = null,
  public val poolId: String? = null,
  public val prvX: Int? = null,
  public val trfRes: HciTariffResult? = null,
  public val vm: HciLocationViewMode? = null,
  public val altNameL: List<String> = emptyList(),
  public val childLocL: List<HciLocation> = emptyList(),
  public val dirRefL: List<Int> = emptyList(),
  public val entryLocL: List<Int> = emptyList(),
  public val gidL: List<String> = emptyList(),
  public val gridL: List<HciGrid> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val ovwTrfRefL: List<HciTariffRef> = emptyList(),
  public val pRefL: List<Int> = emptyList(),
  public val pSERefL: List<Int> = emptyList(),
  public val rRefL: List<Int> = emptyList(),
  public val routeL: List<HciLocationRoute> = emptyList(),
  public val stopLocL: List<Int> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
  public val weatherInfos: List<HciWeatherInformation> = emptyList(),
  public val dur: Int = 0,
  public val pCls: Int = -1,
  public val state: HciLocationState = HciLocationState.F,
  public val type: HciLocationType = HciLocationType.U,
  public val wt: Int = 0,
)
