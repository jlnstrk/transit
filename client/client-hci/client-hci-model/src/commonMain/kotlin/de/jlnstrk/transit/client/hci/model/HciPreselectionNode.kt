package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPreselectionNode(
  public val edges: List<HciPreselectionEdge> = emptyList(),
  public val id: String? = null,
  public val loc: HciLocation,
)
