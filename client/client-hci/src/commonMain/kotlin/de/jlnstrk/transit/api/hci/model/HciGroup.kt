package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.request.filter.HciGisFilter
import de.jlnstrk.transit.api.hci.request.filter.HciJourneyFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGroup(
    public val names: List<HciGroupName> = emptyList(),
    public val descrs: List<HciGroupName> = emptyList(),
    public val enabled: Boolean?,
    public val iconCkd: HciIcon?,
    public val iconDis: HciIcon?,
    public val iconUnckd: HciIcon?,
    public val subGrSelMode: HciSubGroupSelectionMode?,
    public val subgroupL: List<HciGroup> = emptyList(),
    public val gisFltrL: List<HciGisFilter> = emptyList(),
    public val jnyFltr: List<HciJourneyFilter> = emptyList(),
)