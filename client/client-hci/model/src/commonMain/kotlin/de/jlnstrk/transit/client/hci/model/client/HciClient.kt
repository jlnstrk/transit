package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCoord
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciClient(
  public val id: HciClientId? = null,
  public val l: String? = null,
  public val name: String? = null,
  public val os: String? = null,
  public val pos: HciCoord? = null,
  public val res: String? = null,
  public val stats: String? = null,
  public val type: HciClientType,
  public val ua: String? = null,
  public val userId: String? = null,
  public val v: Int = 0
)
