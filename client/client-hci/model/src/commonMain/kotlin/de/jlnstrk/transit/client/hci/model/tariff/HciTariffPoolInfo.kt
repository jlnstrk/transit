package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffPoolInfo(
  public val dataSets: List<HciTariffPoolInfoDataSet> = emptyList(),
  public val version: String
)
