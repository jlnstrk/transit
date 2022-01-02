package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffTravellerProfile(
  public val disabledType: HciTariffTravellerProfileDisabledType? = null,
  public val ticketType: HciTariffTravellerTicketType? = null,
  public val type: HciTariffTravellerProfileType? = null,
  public val age: Int = 0,
  public val redtnCard: Int = 0
)
