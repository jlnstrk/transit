package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciProvider(
  public val extCont: HciExternalContent? = null,
  public val id: String? = null,
  public val name: String? = null,
  public val region: String? = null
)
