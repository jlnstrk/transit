package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciColor(
  public val a: Int = 255,
  public val b: Int,
  public val g: Int,
  public val r: Int,
)
