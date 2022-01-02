package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrRTInfo(
  public val ac: Boolean,
  public val algt: Boolean,
  public val arrDly: Int? = null,
  public val brd: Boolean,
  public val cncl: Boolean,
  public val conSecInfo: HciSubscrConSecInfo? = null,
  public val conn: Boolean,
  public val dFormation: String? = null,
  public val ddReason: String? = null,
  public val dep: String,
  public val depDly: Int? = null,
  public val dpc: Boolean,
  public val dpcv: String? = null,
  public val original: HciSubscrRTInfo? = null,
  public val routeHash: String? = null,
  public val sFormation: String? = null,
  public val sdReason: String? = null,
  public val spc: Boolean,
  public val spcv: String? = null,
  public val arrWeatherInfos: List<HciSubscrWeatherInformation> = emptyList(),
  public val changedAttributes: List<HciSubscrRTAttribute> = emptyList(),
  public val depWeatherInfos: List<HciSubscrWeatherInformation> = emptyList(),
  public val himEvents: List<HciSubscrEventHIM> = emptyList()
)
