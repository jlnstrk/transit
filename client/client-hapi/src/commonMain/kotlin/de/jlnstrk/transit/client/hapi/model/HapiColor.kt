package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiColor(
    public val r: Int,
    public val g: Int,
    public val b: Int,
    public val alpha: Int?,
    public val hex: String,
)