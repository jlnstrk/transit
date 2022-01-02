package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffFilterProps(
  public val maxPers: Int? = null,
  public val cardL: List<HciTariffReductionCard> = emptyList(),
  public val classL: List<HciTariffComfortClass> = emptyList(),
  public val typePersL: List<HciTariffTravellerType> = emptyList(),
  public val usageL: List<HciTariffUsage> = emptyList()
)
