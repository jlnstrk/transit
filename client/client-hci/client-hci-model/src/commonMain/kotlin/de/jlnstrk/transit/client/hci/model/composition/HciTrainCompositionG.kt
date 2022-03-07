package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionG(
  public val i: String,
  public val C: List<HciTrainCompositionC> = emptyList(),
  public val T: List<HciTrainCompositionT> = emptyList(),
  public val fc: Int = 0,
  public val lc: Int = 0,
  public val r: Boolean = false
)
