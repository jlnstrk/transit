package de.jlnstrk.transit.client.hci.model.fare

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciFarePrice(
  public val AMT: Int,
  public val CUR: String? = null,
  public val VID: String? = null,
  public val VAT: Int = 0,
  public val VR: Int = 0
)
