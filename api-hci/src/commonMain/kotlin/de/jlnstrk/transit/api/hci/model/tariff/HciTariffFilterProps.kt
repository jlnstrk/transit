package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffFilterProps(
    public val cardL: List<HciTariffReductionCard> = emptyList(),
    public val classL: List<HciTariffComfortClass> = emptyList(),
    public val maxPers: Int?,
    public val typePersL: List<HciTariffTravellerType> = emptyList(),
    public val usageL: List<HciTariffUsage> = emptyList(),
)