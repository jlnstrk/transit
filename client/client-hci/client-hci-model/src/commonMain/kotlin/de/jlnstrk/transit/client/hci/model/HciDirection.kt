package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciDirection(
  public val did: String? = null,
  public val flg: String? = null,
  public val key: String? = null,
  public val locX: Int? = null,
  public val txt: String? = null,
  public val jnyRefL: List<Int> = emptyList(),
  public val locRefL: List<Int> = emptyList(),
  public val pRefL: List<Int> = emptyList(),
  public val geo: Int = -1,
)
