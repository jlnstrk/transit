package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.HciCompat
import de.jlnstrk.transit.client.hci.model.HciPlatform
import de.jlnstrk.transit.client.hci.model.HciTimeFormat
import de.jlnstrk.transit.client.hci.model.composition.HciTrainComposition
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.serializer.HciZoneOffsetSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.ZoneOffset
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyStop(
  public val aCaS: Boolean = false,
  public val aCncl: Boolean = false,
  public val aDirFlg: String? = null,
  public val aDirTxt: String? = null,
  public val aHide: Boolean = false,
  public val aIconRX: Int? = null,
  public val aLocX: Int? = null,
  public val aOutR: Boolean? = null,
  public val aOutS: Boolean = true,
  public val aPlatfCh: Boolean = false,
  public val aPltfR: HciPlatform? = null,
  public val aPltfS: HciPlatform? = null,
  public val aProdX: Int? = null,
  public val aProgType: HciJourneyProgType? = null,
  public val aStat: HciJourneyStatistics? = null,
  @Serializable(with = HciZoneOffsetSerializer::class)
  public val aTZOffset: ZoneOffset? = null,
  public val aTimeFC: HciTimeFormat? = null,
  public val aTimeFR: HciTimeFormat? = null,
  public val aTimeFS: HciTimeFormat? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTimeR: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val aTimeS: HciLocalTime? = null,
  public val aTimeSCh: Boolean = false,
  public val aTrnCmpSX: HciTrainComposition? = null,
  public val border: Boolean = false,
  public val dCaS: Boolean = false,
  public val dCncl: Boolean = false,
  public val dDirFlg: String? = null,
  public val dDirTxt: String? = null,
  public val dHide: Boolean = false,
  public val dIconRX: Int? = null,
  public val dInR: Boolean? = null,
  public val dInS: Boolean = true,
  public val dLocX: Int? = null,
  public val dPlatfCh: Boolean = false,
  public val dPltfR: HciPlatform? = null,
  public val dPltfS: HciPlatform? = null,
  public val dProdX: Int? = null,
  public val dProgType: HciJourneyProgType? = null,
  public val dStat: HciJourneyStatistics? = null,
  @Serializable(with = HciZoneOffsetSerializer::class)
  public val dTZOffset: ZoneOffset? = null,
  public val dTimeFC: HciTimeFormat? = null,
  public val dTimeFR: HciTimeFormat? = null,
  public val dTimeFS: HciTimeFormat? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTimeR: HciLocalTime? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val dTimeS: HciLocalTime? = null,
  public val dTimeSCh: Boolean = false,
  public val dTrnCmpSX: HciTrainComposition? = null,
  public val idx: Int? = null,
  public val isAdd: Boolean = false,
  public val isImp: Boolean = false,
  public val locX: Int? = null,
  public val matchData: HciJourneyStopMatchData? = null,
  public val mcp: HciLocation? = null,
  public val psCtxArrE: String? = null,
  public val psCtxDepL: String? = null,
  public val type: HciJourneyStopType? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val aCnclRtSrcX: Int = -1,
  public val aDirGeo: Int = 0,
  public val dCnclRtSrcX: Int = -1,
  public val dDirGeo: Int = 0,
  @Deprecated("Removed after HCI version 1.21, but before version 1.24")
  @HciCompat(
    removedAfter = "1.21",
    removedBefore = "1.24"
  )
  public val aPlatfS: String? = null,
  @Deprecated("Removed after HCI version 1.21, but before version 1.24")
  @HciCompat(
    removedAfter = "1.21",
    removedBefore = "1.24"
  )
  public val aPlatfR: String? = null,
  @Deprecated("Removed after HCI version 1.21, but before version 1.24")
  @HciCompat(
    removedAfter = "1.21",
    removedBefore = "1.24"
  )
  public val dPlatfS: String? = null,
  @Deprecated("Removed after HCI version 1.21, but before version 1.24")
  @HciCompat(
    removedAfter = "1.21",
    removedBefore = "1.24"
  )
  public val dPlatfR: String? = null
)
