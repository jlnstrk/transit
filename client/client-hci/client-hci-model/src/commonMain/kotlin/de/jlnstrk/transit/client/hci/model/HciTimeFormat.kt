package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTimeFormat(
  public val styleX: Int? = null,
  public val txt: String? = null,
  public val txtA: String? = null,
)
