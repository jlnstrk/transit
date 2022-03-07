package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationInput(
  public val `field`: HciLocationField,
  public val loc: HciLocation,
  public val locFltrL: List<HciLocationFilter> = emptyList(),
  public val maxLoc: Int = 25,
  public val prvCtx: String? = null
)
