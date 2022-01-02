package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSimpleTrainCompositionCar(
  public val attrL: List<HciTrainCompositionA> = emptyList(),
  public val number: String? = null,
  public val sect: String? = null,
  public val type: Int? = null
)
