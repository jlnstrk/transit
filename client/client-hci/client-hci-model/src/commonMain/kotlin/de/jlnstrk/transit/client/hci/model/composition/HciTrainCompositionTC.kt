package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTrainCompositionTC(
  public val GR: List<HciTrainCompositionGR> = emptyList(),
  public val T: List<HciTrainCompositionT> = emptyList(),
  public val d: HciTrainCompositionDirection = HciTrainCompositionDirection.A,
  public val r: Boolean = false,
  public val v: HciTrainCompositionValidity = HciTrainCompositionValidity.B,
)
