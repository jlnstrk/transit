package de.jlnstrk.transit.api.hci.model.tariff

import kotlinx.serialization.Serializable

@Serializable
public data class HciTariffVariant(
    public val text: String?,
    public val trfCtx: String?,
)