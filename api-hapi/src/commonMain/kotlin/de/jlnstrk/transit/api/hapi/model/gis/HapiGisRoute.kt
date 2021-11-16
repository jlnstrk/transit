@file:UseSerializers(
    HapiSecondsSerializer::class
)

package de.jlnstrk.transit.api.hapi.model.gis

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiNote
import de.jlnstrk.transit.api.hapi.model.HapiPolyline
import de.jlnstrk.transit.api.hapi.model.HapiPolylineGroup
import de.jlnstrk.transit.api.hapi.serializer.HapiSecondsSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiGisRoute(
    /** Distance for this GIS route in meter. */
    public val dist: Int?,
    /** Duration for this GIS route in seconds. */
    public val durS: Duration?,
    /** Duration for this GIS route in seconds based on the realtime situation. */
    public val durR: Duration?,
    /** Estimated search time for a parking place in seconds. */
    public val durST: Duration?,
    /** Estimated walking time from the starting address to the parking place in seconds. */
    public val durW2C: Duration?,
    /** Estimated walking time from the destination parking place to the destination address in seconds. */
    public val durW2D: Duration?,
    /** Direction text */
    public val dirTxt: String?,
    /** Geographical direction of the route.
     * The direction range is from 0 to 31 with 0 starting from the x-axis in mathematical positive direction. */
    public val dirGeo: Int?,
    /** Hash-Value over the edge list that represented the segments of the polyline when it was originally searched. */
    public val edgeHashS: String?,
    /** Hash-Value over the edge list that represents the segments of the polyline for the current request. */
    public val edgeHashR: String?,
    public val seg: List<HapiGisRouteSegment> = emptyList(),
    public val Notes: List<HapiNote> = emptyList(),
    public val polyline: HapiPolyline?,
    public val polylineGroup: HapiPolylineGroup?,
    public val altPolyline: List<HapiPolyline> = emptyList(),
    public val altPolylineGrup: List<HapiPolylineGroup> = emptyList(),
)