package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMatchAffectedRouteDirection(
  public val flag: String? = null,
  public val key: String? = null,
  public val txt: String? = null,
)
