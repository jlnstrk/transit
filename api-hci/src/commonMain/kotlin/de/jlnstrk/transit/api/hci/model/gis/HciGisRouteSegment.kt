package de.jlnstrk.transit.api.hci.model.gis

import de.jlnstrk.transit.api.hafas.HafasGisManeuver
import de.jlnstrk.transit.api.hafas.HafasGisOrientation
import de.jlnstrk.transit.api.hafas.HafasGisRoadType
import kotlinx.serialization.Serializable

@Serializable
public data class HciGisRouteSegment(
    /** Segment name for display */
    public val name: String?,

    /** Road type for this segment */
    public val rType: HafasGisRoadType,

    /** Road number if available */
    public val rNum: String?,

    /** Orientation before the maneuver */
    public val ori: HafasGisOrientation?,

    /** Code for the manoeuvre to be executed */
    public val man: HafasGisManeuver?,

    /** Text description for the manoeuvre */
    public val manTx: String,

    /** Starting index into the polyline array */
    public val polyS: Int,

    /** End index into the polyline array */
    public val polyE: Int,

    /** Distance for this leg in meter */
    public val dist: Int,

    public val icoX: Int
)