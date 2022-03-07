package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionC(
  public val i: String? = null,
  public val n: String? = null,
  public val s: String? = null,
  public val t: String? = null,
  public val tcctX: Int? = null,
  public val A: List<HciTrainCompositionA> = emptyList(),
  public val l: Int = 0,
  public val r: Boolean = false
)
