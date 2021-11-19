package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationRoute(
    public val locX: Int,
    public val routeNum: String,
    public val startStation: String?,
    public val endStation: String?,
)