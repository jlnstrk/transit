package de.jlnstrk.transit.client.hapi.model.tariff

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiPricing(
    public val idx: Int,
)