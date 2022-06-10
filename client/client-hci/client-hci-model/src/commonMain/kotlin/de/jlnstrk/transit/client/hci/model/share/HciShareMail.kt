package de.jlnstrk.transit.client.hci.model.share

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciShareMail(
  public val comment: String? = null,
  public val recvAddr: String,
  public val sendAddr: String? = null,
  public val sendName: String? = null,
)
