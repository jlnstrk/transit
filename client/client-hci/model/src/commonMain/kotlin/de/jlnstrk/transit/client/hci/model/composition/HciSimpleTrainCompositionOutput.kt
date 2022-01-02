package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSimpleTrainCompositionOutput(
  public val dir: HciSimpleTrainCompositionLeavingDirection? = null,
  public val groupL: List<Int> = emptyList()
)
