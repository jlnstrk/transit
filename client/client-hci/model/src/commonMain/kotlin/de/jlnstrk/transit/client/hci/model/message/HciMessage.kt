package de.jlnstrk.transit.client.hci.model.message

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciColor
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciMessage(
  public val extCX: Int? = null,
  public val fIdx: Int? = null,
  public val fLocX: Int? = null,
  public val himX: Int? = null,
  public val remX: Int? = null,
  public val sty: HciMessageStyleType? = null,
  public val tIdx: Int? = null,
  public val tLocX: Int? = null,
  public val trfMsgX: Int? = null,
  public val txtC: HciColor? = null,
  public val type: HciMessageType,
  public val childRemXL: List<Int> = emptyList(),
  public val cntL: List<HciMessageContentType> = emptyList(),
  public val frmL: List<HciMessageFormatType> = emptyList(),
  public val tagL: List<HciMessageTagType> = emptyList(),
  public val dspl: HciMessageDisplayType = HciMessageDisplayType.U,
  public val minor: Int = 0,
  public val persist: Boolean = true,
  public val prio: Int = 0,
  public val sort: Int = 2147483647
)
