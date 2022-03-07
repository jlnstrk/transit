package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSpatialFareValidity(
  public val DL: Int? = null,
  public val DS: Int? = null,
  public val OL: Int? = null,
  public val OS: Int? = null,
  public val RI: Int? = null,
  public val VL: List<Int> = emptyList()
)
