package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionA(
  public val c: String,
  public val T: List<HciTrainCompositionT> = emptyList(),
  public val n: Boolean = false,
  public val p: HciTrainCompositionPriority = HciTrainCompositionPriority.N,
)
