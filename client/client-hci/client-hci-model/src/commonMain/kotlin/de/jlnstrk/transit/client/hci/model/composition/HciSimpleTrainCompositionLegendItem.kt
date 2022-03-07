package de.jlnstrk.transit.client.hci.model.composition

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSimpleTrainCompositionLegendItem(
  public val id: String? = null,
  public val refersTo: String? = null,
  public val text: String? = null
)
