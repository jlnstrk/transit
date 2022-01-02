package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionCT(
  public val A: List<HciTrainCompositionA> = emptyList(),
  public val i: String,
  public val l: Int,
  public val s: String? = null,
  public val t: String? = null
)
