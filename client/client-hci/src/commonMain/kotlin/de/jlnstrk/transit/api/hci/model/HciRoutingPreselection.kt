package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.gis.HciGisProfile
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciRoutingPreselection(
    public val gisProfile: HciGisProfile,
    public val nodes: List<HciPreselectionNode> = emptyList(),
)