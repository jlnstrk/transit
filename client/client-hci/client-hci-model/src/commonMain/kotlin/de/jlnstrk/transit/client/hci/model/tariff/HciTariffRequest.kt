package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffRequest(
  public val cId: String? = null,
  public val cType: HciTariffCustomerType? = null,
  public val tarMode: String? = null,
  public val tvlrProfData: String? = null,
  public val tixList: List<HciTariffTicket> = emptyList(),
  public val tvlrProf: List<HciTariffTravellerProfile> = emptyList(),
  public val jnyCl: Int = 0,
  public val rType: HciTariffRequestType = HciTariffRequestType.FULL,
  public val tixCheck: Boolean = false
)
