package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciServiceDays(
  public val fLocIdx: Int? = null,
  public val fLocX: Int? = null,
  public val sDaysB: String? = null,
  public val sDaysI: String? = null,
  public val sDaysR: String? = null,
  public val tLocIdx: Int? = null,
  public val tLocX: Int? = null,
)
