package de.jlnstrk.transit.api.hapi.model.gis

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiGisEdge(
    public val edgeId: String?,
    public val graphId: String?,
)