package de.jlnstrk.transit.api.hci.model.him

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciPolylineGroup
import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import de.jlnstrk.transit.api.hci.model.geo.HciGeoRing
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciHimMessageRegion(
    public val icoCord: HciCoord?,
    public val icoX: Int?,
    public val id: String?,
    public val name: String?,
    public val polyG: HciPolylineGroup?,
    public val ring: HciGeoRing?,
    public val msgRefL: List<Int> = emptyList(),
    public val polyTypeL: List<Boolean> = emptyList()
)