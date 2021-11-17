package de.jlnstrk.transit.api.hci.model.gis

import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.model.HciPolylineGroup
import de.jlnstrk.transit.api.hci.serializer.time.HciDurationSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable

@Serializable
public data class HciGis(
    /** Distance for this GIS route in meter */
    public val dist: Int,

    /** Duration for this GIS route in seconds */
    @Serializable(with = HciDurationSerializer::class)
    public val durS: Duration,

    /** Duration for this GIS route in seconds based on the realtime situation */
    @Serializable(with = HciDurationSerializer::class)
    public val durR: Duration?,

    /** Estimated search time for a parking place in seconds */
    @Serializable(with = HciDurationSerializer::class)
    public val durST: Duration?,

    public val polyG: HciPolylineGroup?,

    public val getDescr: Boolean?,

    public val getPoly: Boolean?,

    public val ctx: String?,

    public val segL: List<HciGisRouteSegment> = emptyList(),

    /** The type of provider of this GIS route */
    public val gisPrvr: HciGisProvider?,

    /** Geographical direction of the route.
     * The direction range is from 0 to 31 with 0 starting from the x-axis
     * in mathematical positive direction */
    public val dirGeo: Int?,

    // TODO: Purpose?
    public val sumLDrawStyleX: Int?,

    // TODO: Purpose?
    public val resLDrawStyleX: Int?,

    public val prodX: Int?,

    public val msgL: List<HciMessage> = emptyList()
) {

    @Serializable
    public enum class Type {
        // TODO: Meaning?
        B,

        // TODO: Meaning?
        F,

        // TODO: Meaning?
        K,

        // TODO: Meaning?
        P,

        // TODO: Meaning?
        T,

        // TODO: Meaning?
        TE,

        // TODO: Meaning?
        U
    }
}