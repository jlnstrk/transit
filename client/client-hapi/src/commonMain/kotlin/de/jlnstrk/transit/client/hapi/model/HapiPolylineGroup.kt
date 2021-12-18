package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiPolylineGroup(
    /** List of polyline descriptions. */
    public val polylineDesc: List<HapiPolyline> = emptyList(),
    public val name: String?,
    /** Type of coordinate system. */
    public val coordType: HapiCoord.Type = HapiCoord.Type.WGS84,
    /** Display name of layer. */
    public val layerName: String?,
)