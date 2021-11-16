package de.jlnstrk.transit.api.hapi.model.tariff

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiPair
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiFareItem(
    public val name: String,
    public val desc: String?,
    public val price: Int = 0,
    public val cur: String?,
    public val shpCtx: String?,
    /** First leg this fare item is valid for. */
    public val fromLeg: Int?,
    /** Last leg this fare item is valid for. */
    public val toLeg: Int?,
    public val ticket: List<HapiTicket> = emptyList(),
    public val param: List<HapiPair> = emptyList(),
)