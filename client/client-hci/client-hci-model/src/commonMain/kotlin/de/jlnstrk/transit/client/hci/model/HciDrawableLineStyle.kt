package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciDrawableLineStyle(
  public val bg: HciColor? = null,
  public val brd: HciColor? = null,
  public val eIcoX: Int? = null,
  public val sIcoX: Int? = null,
  public val type: HciDrawableLineStyleType = HciDrawableLineStyleType.SOLID,
  public val zIdx: Int? = null,
)
