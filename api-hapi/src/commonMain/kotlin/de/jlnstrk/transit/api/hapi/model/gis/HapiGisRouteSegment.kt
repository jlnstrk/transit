package de.jlnstrk.transit.api.hapi.model.gis

import de.jlnstrk.transit.api.hafas.*
import de.jlnstrk.transit.api.hapi.model.HapiNote
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiGisRouteSegment(
    public val Notes: List<HapiNote> = emptyList(),
    public val Edge: List<HapiGisEdge> = emptyList(),
    /** Segment name for display. */
    public val name: String?,
    /** Road type for this segment. */
    public val rType: HafasGisRoadType?,
    /** Road number if available. */
    public val rNum: String?,
    /** Code for the manoeuvre to be executed. */
    public val man: HafasGisManeuver?,
    /** Text description for the manoeuvre */
    public val manTx: String?,
    /** Name or description of the target of the current manoeuvre */
    public val manTargetName: String?,
    /** Direction text */
    public val dirTx: String?,
    /** Orientation */
    public val ori: HafasGisOrientation?,
    /** Starting index into the polyline array. */
    public val polyS: Int?,
    /** End index into the polyline array */
    public val polyE: Int?,
    /** Distance for this leg in meter. */
    public val dist: Int?,
)