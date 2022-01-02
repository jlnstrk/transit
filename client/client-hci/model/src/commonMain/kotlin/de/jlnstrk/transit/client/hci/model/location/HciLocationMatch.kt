package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationMatch(
  public val `field`: HciLocationField? = null,
  public val locL: List<HciLocation> = emptyList(),
  public val state: HciLocationMatchState = HciLocationMatchState.U
)
