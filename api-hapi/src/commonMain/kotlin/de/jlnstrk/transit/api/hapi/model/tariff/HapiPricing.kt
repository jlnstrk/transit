package de.jlnstrk.transit.api.hapi.model.tariff

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiPricing(
    public val idx: Int,
)