package de.jlnstrk.transit.api.hci.model.geo

import kotlinx.serialization.Serializable

@Serializable
public data class HciMapLayer(
    public val alpha: Int?,
    public val attrb: String?,
    public val extent: HciGeoRectangle?,
    public val icoX: Int?,
    public val id: String,
    public val initBox: HciGeoRectangle?,
    public val lbl: String?,
    public val proj: Projection?,
    public val subd: List<String> = emptyList(),
    public val type: String?,
    public val url: String?,
    public val zoomMin: Int?,
    public val zoomMax: Int?,
) {

    @Serializable
    public enum class Projection {
        // TODO: Meaning?
        B,

        // TODO: Meaning?
        E,

        // TODO: Meaning?
        S,

        // TODO: Meaning?
        U,

        // TODO: Meaning?
        Z
    }
}