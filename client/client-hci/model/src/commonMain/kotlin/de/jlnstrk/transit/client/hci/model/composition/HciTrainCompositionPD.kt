package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionPD(
  public val i: String? = null,
  public val x: Int? = null,
  public val PS: List<HciTrainCompositionPS> = emptyList(),
  public val b: Boolean = false,
  public val d: HciTrainCompositionDirection = HciTrainCompositionDirection.A,
  public val s: Int = 0
)
