package de.jlnstrk.transit.api.hci.model.geo

import de.jlnstrk.transit.api.hci.model.graph.HciGraphNode
import de.jlnstrk.transit.api.hci.model.HciCommon
import kotlinx.serialization.Serializable

@Serializable
public data class HciCoord(
    /** The x-coordinate of these coordinates */
    public val x: Long,

    /** The y-coordinate of these coordinates */
    public val y: Long,

    /** The z-coordinate of these coordinates */
    public val z: Long? = null,

    // /** The type of coordinate system used to encode [x], [y] and [z] */
    // public val type: Type? = null,

    /** The index of these coordinates' layer into [HciCommon.layerL] */
    public val layerX: Int? = null,

    /** The index of these coordinates' coordinate system into [HciCommon.crdSysL] */
    public val crdSysX: Int? = null,

    /** The building floor of these coordinates */
    public val floor: Int? = null,

    // TODO: Purpose?
    public val viewAlternatives: List<HciGraphNode> = emptyList(),
) {

    @Serializable
    public enum class Type {
        FLAT,
        HAFASGEO,
        PLANAR,
        WGS84,
    }
}