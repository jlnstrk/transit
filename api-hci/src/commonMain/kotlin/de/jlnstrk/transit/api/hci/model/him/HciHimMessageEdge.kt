package de.jlnstrk.transit.api.hci.model.him

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciPolylineGroup
import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciHimMessageEdge(
    /** The direction of this edge, range 0..31 */
    public val dir: Int?,
    public val fLocX: Int?,
    public val icoCrd: HciCoord?,
    public val polyG: HciPolylineGroup?,
    public val msgRefL: List<Int> = emptyList(),
    public val tLocX: Int?,
)