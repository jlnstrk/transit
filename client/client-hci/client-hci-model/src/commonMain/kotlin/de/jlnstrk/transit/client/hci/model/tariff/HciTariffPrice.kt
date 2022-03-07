package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffPrice(
  public val amount: Int? = null,
  public val currency: String? = null,
  public val prefix: String? = null,
  public val suffix: String? = null,
  public val upperBound: Int? = null
)
