package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciProductStatus(
  public val himIcoX: Int? = null,
  public val icoX: Int? = null,
  public val rtIcoX: Int? = null,
  public val txt: String? = null,
  public val delCntL: List<Int> = emptyList(),
  public val delGrpL: List<Int> = emptyList(),
  public val aCncl: Int = 0,
  public val aDel: Int = 0,
  public val aOnt: Int = 0,
  public val aPartCncl: Int = 0,
  public val cncl: Int = 0,
  public val cnt: Int = 0,
  public val code: Int = 0,
  public val him: Int = 0,
  public val ont: Int = 0,
  public val rt: Int = 0
)
