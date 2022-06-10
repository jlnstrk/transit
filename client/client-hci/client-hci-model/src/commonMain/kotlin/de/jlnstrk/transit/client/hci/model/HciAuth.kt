package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciAuth(
  public val aid: String? = null,
  public val hash: String? = null,
  public val mac: String? = null,
  public val mic: String? = null,
  public val pw: String? = null,
  public val type: HciAuthType,
  public val user: String? = null,
)
