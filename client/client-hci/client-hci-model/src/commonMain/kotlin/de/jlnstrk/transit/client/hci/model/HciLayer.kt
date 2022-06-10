package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLayer(
  public val id: String? = null,
  public val name: String? = null,
  public val index: Int = 0,
  public val annoCnt: Int = 0,
)
