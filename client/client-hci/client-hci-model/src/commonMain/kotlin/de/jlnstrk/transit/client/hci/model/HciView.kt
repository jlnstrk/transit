package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciView(
  public val id: String,
  public val index: Int,
  public val name: String? = null,
  public val tile: String? = null,
  public val type: HciCoordType = HciCoordType.WGS_84,
)
