package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hci.request.HciRequestEnvelope
import kotlinx.serialization.Serializable

@Serializable
public data class HciPolyline(
    public val delta: Boolean,

    /** The number of dimensions used with this polyline */
    public val dim: Int,

    /** The non-encoded coordinates of this polyline in steps of [dim] */
    public val crd: List<Double> = emptyList(),

    /** Returns this polyline's y- and x-coordinates as an encoded string.
     * See [HciRequestEnvelope.Configuration.polyEnc] */
    public val crdEncYX: String?,

    /** Returns this polyline's z-coordinates as an encoded string.
     * See [HciRequestEnvelope.Configuration.polyEnc] */
    public val crdEncZ: String?,

    // TODO: Purpose + Format?
    public val crdEncS: String,

    // TODO: Purpose + Format?
    public val crdEncF: String,

    /** The mapping of points to locations for this polyline */
    public val ppLocRefL: List<LocationReference> = emptyList(),

    public val lDrawStyleX: Int?
) {

    @Serializable
    public data class LocationReference(
        /** The index of a point in e.g. [HciPolyline.crd].
         * In this case, it would be `[ppIdx] * [HciPolyline.dim]` */
        public val ppIdx: Int,

        /** The index of the associated location into [HciCommon.locL] */
        public val locX: Int
    )

}