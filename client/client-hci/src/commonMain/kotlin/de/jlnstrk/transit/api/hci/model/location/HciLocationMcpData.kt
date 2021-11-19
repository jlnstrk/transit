package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciExternalContent
import de.jlnstrk.transit.api.hci.model.HciTransportMode
import de.jlnstrk.transit.api.hci.model.HciUsageType
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationMcpData(
    public val clickout: String?,
    public val details: String?,
    public val extCont: HciExternalContent?,
    public val externalId: String?,
    public val lastUpd: String?,
    public val lastUpdTime: String?,
    public val mcpid: String?,
    public val occupancy: HciLocationMcpOccupancy?,
    public val placeType: HciMcpPlaceType?,
    public val provider: String?,
    public val providerName: String?,
    public val transportMode: HciTransportMode?,
    public val type: HciLocationMcpType?,
    public val usageType: HciUsageType?,
)