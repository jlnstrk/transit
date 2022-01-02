package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRevitalizedLocation(
  public val eteId: String? = null,
  public val loc: HciLocation? = null,
  public val state: HciRevitalizedLocationState = HciRevitalizedLocationState.BR
)
