package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.geo.HciCoord
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciView(
    public val id: String,
    public val index: Int,
    public val type: HciCoord.Type
)