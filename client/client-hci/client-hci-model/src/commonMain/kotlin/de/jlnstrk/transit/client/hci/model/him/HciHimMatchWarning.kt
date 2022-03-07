package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchWarning(
  public val ctx: String? = null,
  public val code: Int = 0,
  public val idx: Int = 0,
  public val puic: Int = 0
)
