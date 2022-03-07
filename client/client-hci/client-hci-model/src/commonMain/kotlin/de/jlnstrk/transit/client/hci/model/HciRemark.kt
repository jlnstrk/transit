package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRemark(
  public val code: String? = null,
  public val icoX: Int? = null,
  public val jid: String? = null,
  public val rtActivated: Boolean? = null,
  public val rtDeactivated: Boolean? = null,
  public val sIdx: Int? = null,
  public val txtL: String? = null,
  public val txtN: String? = null,
  public val txtS: String? = null,
  public val url: String? = null,
  public val isImp: Boolean = false,
  public val prio: Int = 100,
  public val type: HciRemarkType = HciRemarkType.U
)
