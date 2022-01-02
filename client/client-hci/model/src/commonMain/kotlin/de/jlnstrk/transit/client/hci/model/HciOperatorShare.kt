package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.fare.HciFarePrice
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciOperatorShare(
  public val CET: String? = null,
  public val DL: Int? = null,
  public val OL: Int? = null,
  public val OP: Int,
  public val PCS: String? = null,
  public val PRC: HciFarePrice? = null,
  public val SHR: Int = 0
)
