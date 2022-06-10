package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffRef(
  public val fareSetX: Int,
  public val fareX: Int? = null,
  public val ticketX: Int? = null,
  public val type: HciTariffRefType,
)
