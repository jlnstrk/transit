package de.jlnstrk.transit.client.hci.model.share

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciShareSMS(
  public val msg: String? = null,
  public val recvNum: String
)
