package de.jlnstrk.transit.api.hci.model.gis

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGisProfile(
    public val type: HciGis.Type,
    public val attrExcl: String?,
    public val attrIncl: String?,
    public val checkInTime: Int?,
    public val checkOutTime: Int?,
    public val cost: Int?,
    public val durationOfStay: Int?,
    public val enabled: Boolean?,
    public val geometry: Int?,
    public val linDistRouting: Boolean?,
    public val maxdist: Int?,
    public val maxdur: Int?,
    public val mindist: Int?,
    public val opt: Int?,
    public val radius: Int?,
    public val route: String?,
    public val speed: Int?,
    public val waittime: Int?,
)