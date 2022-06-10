package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciClientFilterOption(
  public val gui: HciClientFilterGui? = null,
  public val mode: HciClientFilterMode = HciClientFilterMode.INC,
  public val req: Boolean = false,
  public val `set`: Boolean = false,
  public val `val`: String,
)
