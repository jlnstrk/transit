package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.message.HciMessageContentType
import de.jlnstrk.transit.client.hci.model.message.HciMessageFormatType
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGridItem(
  public val col: Int,
  public val row: Int,
  public val txtC: HciColor? = null,
  public val cntL: List<HciMessageContentType> = emptyList(),
  public val frmL: List<HciMessageFormatType> = emptyList(),
  public val remL: List<Int> = emptyList(),
)
