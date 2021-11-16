package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationWalk(
    public val extId: Long,
    public val fLocX: Int?,
    public val tLocX: Int?,
    public val polyG: HciPolylineGroup?,
    public val himXL: List<Int> = emptyList(),
    public val remXL: List<Int> = emptyList(),
)