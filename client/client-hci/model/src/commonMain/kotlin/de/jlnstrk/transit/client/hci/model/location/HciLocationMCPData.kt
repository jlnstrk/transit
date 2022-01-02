package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciExternalContent
import de.jlnstrk.transit.client.hci.model.HciMCPPlaceType
import de.jlnstrk.transit.client.hci.model.HciTransportMode
import de.jlnstrk.transit.client.hci.model.HciUsageType
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciLocationMCPData(
  public val clickout: String? = null,
  public val details: String? = null,
  public val extCont: HciExternalContent? = null,
  public val externalId: String? = null,
  public val lastUpd: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val lastUpdTime: HciLocalTime? = null,
  public val mcpid: String? = null,
  public val provider: String? = null,
  public val providerName: String? = null,
  public val occupancy: HciLocationMCPOccupancyType = HciLocationMCPOccupancyType.N,
  public val placeType: HciMCPPlaceType = HciMCPPlaceType.UNDEF,
  public val transportMode: HciTransportMode = HciTransportMode.UNDEF,
  public val type: HciLocationMCPType = HciLocationMCPType.U,
  public val usageType: HciUsageType = HciUsageType.U
)
