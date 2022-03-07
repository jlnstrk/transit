package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTimeDisplayStyle(
  public val bg: HciColor? = null,
  public val brd: HciColor? = null,
  public val fg: HciColor? = null,
  public val icoX: Int? = null,
  public val mode: HciTimeDisplayMode,
  public val strikeOut: Boolean = false
)
