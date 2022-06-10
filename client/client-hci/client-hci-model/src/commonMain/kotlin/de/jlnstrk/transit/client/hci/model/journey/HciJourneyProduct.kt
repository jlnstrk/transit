package de.jlnstrk.transit.client.hci.model.journey

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciJourneyProduct(
  public val fIdx: Int? = null,
  public val fLocX: Int? = null,
  public val prodX: Int? = null,
  public val tIdx: Int? = null,
  public val tLocX: Int? = null,
)
