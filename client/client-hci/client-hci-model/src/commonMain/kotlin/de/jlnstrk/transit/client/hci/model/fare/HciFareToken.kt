package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFareToken(
  public val mode: HciFareTokenMode? = null,
  public val num: Int? = null,
  public val type: String? = null,
)
