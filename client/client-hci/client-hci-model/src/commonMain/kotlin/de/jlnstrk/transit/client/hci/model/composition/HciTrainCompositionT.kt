package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionT(
  public val a: String? = null,
  public val l: String? = null,
  public val n: String? = null,
  public val p: HciTrainCompositionPriority = HciTrainCompositionPriority.N,
  public val s: String? = null
)
