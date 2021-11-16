package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciMapLayerExt(
    public val mapLayX: Int?,
    public val selectable: Boolean?,
    public val show: Boolean?,
)