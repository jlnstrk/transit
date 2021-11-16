package de.jlnstrk.transit.api.hci.model.geo

import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import kotlinx.serialization.Serializable

@Serializable
public data class HciGeoRectangle(
    public val llCrd: HciCoord,
    public val urCrd: HciCoord
)