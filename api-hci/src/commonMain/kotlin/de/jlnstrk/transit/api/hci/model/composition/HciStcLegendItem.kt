package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciStcLegendItem(
    public val id: String?,
    public val text: String?,
    public val refersTo: String?,
)