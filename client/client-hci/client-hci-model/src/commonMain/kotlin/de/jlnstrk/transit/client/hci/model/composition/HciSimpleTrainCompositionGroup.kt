package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSimpleTrainCompositionGroup(
  public val dest: String? = null,
  public val carL: List<Int> = emptyList(),
  public val liXL: List<Int> = emptyList(),
)
