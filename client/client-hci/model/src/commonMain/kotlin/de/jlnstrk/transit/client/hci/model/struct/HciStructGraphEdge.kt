package de.jlnstrk.transit.client.hci.model.struct

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciStructGraphEdge(
  public val fromNodeX: Int? = null,
  public val id: String? = null,
  public val toNodeX: Int? = null
)
