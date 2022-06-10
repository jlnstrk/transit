package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciMapLayerExt(
  public val mapLayX: Int? = null,
  public val selectable: Boolean = true,
  public val show: Boolean = false,
)
