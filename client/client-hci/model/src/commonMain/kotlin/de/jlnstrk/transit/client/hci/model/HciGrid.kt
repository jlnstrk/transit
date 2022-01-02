package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGrid(
  public val itemL: List<HciGridItem> = emptyList(),
  public val nCols: Int,
  public val nRows: Int,
  public val title: String? = null,
  public val type: HciGridContentType
)
