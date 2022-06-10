package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationNGrammFilter(
  public val attr: String? = null,
  public val crd: HciCoord? = null,
  public val endIds: String? = null,
  public val fTxt: String? = null,
  public val maxDist: Int = 0,
  public val prefix: String? = null,
  public val startIds: String? = null,
  public val type: HciLocationNGrammFilterMode,
)
