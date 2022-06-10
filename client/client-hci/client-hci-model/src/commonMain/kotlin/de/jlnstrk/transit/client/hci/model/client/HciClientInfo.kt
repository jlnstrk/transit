package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciClientInfo(
  public val code: HciClientInfoCode,
  public val msg: String? = null,
  public val url: String? = null,
)
