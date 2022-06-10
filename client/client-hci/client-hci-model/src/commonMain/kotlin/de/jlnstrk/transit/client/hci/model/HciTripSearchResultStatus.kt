package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTripSearchResultStatus(
  public val timeDiffCritical: Boolean = false,
)
