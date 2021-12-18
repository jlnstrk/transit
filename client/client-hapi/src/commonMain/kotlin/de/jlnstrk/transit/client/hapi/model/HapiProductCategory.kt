package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Product category info. */
@HapiXsd("1.29")
@Serializable
public data class HapiProductCategory(
    public val Product: List<HapiProduct> = emptyList(),
    /** Operator name for display. */
    public val name: String,
    /** Product category in decimal form. */
    public val cls: String?,
)