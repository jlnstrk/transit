package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.gis.HciGisProfile
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRoutingPreselection(
  public val gisProfile: HciGisProfile,
  public val nodes: List<HciPreselectionNode> = emptyList()
)
