package de.jlnstrk.transit.client.hapi.model.location

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public enum class HapiLocationType {
    ST,
    ADR,
    POI,
    CRD,
    HL,
    MCP,
}