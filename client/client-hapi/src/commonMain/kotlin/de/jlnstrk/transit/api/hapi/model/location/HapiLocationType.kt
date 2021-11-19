package de.jlnstrk.transit.api.hapi.model.location

import de.jlnstrk.transit.api.hafas.HapiXsd
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