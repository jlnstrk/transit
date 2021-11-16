package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffPrice(
    public val amount: Int,
    public val currency: String
)