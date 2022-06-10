package de.jlnstrk.transit.client.hci.model.event

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciEventGroup(
  public val icoX: Int? = null,
  public val id: String? = null,
  public val name: String? = null,
)
