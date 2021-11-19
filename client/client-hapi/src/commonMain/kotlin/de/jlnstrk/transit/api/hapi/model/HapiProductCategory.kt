package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
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