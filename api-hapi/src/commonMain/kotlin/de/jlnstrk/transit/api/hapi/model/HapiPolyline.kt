package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Describes a polyline structure */
@HapiXsd("1.29")
@Serializable
public data class HapiPolyline(
    /** List of coordinates. Attribute "dim" defines how many items are used to build one coordinate tuple.
     * In case of dim=3, z is in meter per default. */
    public val crd: List<Double> = emptyList(),
    public val name: String?,
    /** true: After the first item of the coordinates list only diff values are listed.
     * false: list of coordinates contains complete coordinates. */
    public val delta: Boolean,
    /** Count of coordinate elements building one coordinate tuple.
     * (2: x1, y1, x2, y2, ...; 3: x1, y1, z1, x2, y2, z2, ...) */
    public val dim: Int = 2,
    public val type: HapiCoord.Type = HapiCoord.Type.WGS84,
    /** Encoded YX coordinate values. */
    public val crdEncYX: String?,
    /** Encoded Z coordinate values. */
    public val crdEncZ: String?,
    /** Encoded quantifier. */
    public val crdEncS: String?,
)