package de.jlnstrk.transit.api.hci.model.geo

import kotlinx.serialization.Serializable

@Serializable
public data class HciGeoRectangle(
    public val llCrd: HciCoord,
    public val urCrd: HciCoord
)