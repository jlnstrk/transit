package de.jlnstrk.transit.client.hapi.model.tariff

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiPair
import kotlinx.serialization.Serializable

@HapiXsd("1.29")
@Serializable
public data class HapiFareSetItem(
    public val name: String?,
    public val desc: String?,
    /** First leg this fare set is valid for. */
    public val fromLeg: Int?,
    /** Last leg this fare set is valid for. */
    public val toLeg: Int?,
    public val ticketParam: List<HapiPair> = emptyList(),
    public val fareItem: List<HapiFareItem> = emptyList(),
    public val param: List<HapiPair> = emptyList(),
)