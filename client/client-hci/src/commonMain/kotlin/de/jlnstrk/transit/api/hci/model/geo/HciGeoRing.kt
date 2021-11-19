package de.jlnstrk.transit.api.hci.model.geo

import kotlinx.serialization.Serializable

@Serializable
public data class HciGeoRing(
    public val cCrd: HciCoord,
    public val minDist: Int? = null,
    public val maxDist: Int
)