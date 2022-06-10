package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciChange(
  public val durFS: HciTimeFormat? = null,
  public val durS: String? = null,
  public val txt: String,
)
