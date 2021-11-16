package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciPreselectionNode(
    public val loc: HciLocation,
    public val edges: List<HciPreselectionEdge> = emptyList(),
    public val id: String?,
)