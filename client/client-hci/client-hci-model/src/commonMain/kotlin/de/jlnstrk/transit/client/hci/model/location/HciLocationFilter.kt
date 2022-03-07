package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationFilter(
  public val mode: HciLocationFilterMode? = null,
  public val ngramm: HciLocationNGrammFilter? = null,
  public val type: HciLocationFilterType,
  public val `value`: String? = null
)
