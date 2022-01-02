package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionPS(
  public val n: String? = null,
  public val e: Int = 0,
  public val s: Int = 0
)
