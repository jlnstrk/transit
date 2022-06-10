package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.gis.HciGisFilter
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciGroup(
  public val iconCkd: HciIcon? = null,
  public val iconDis: HciIcon? = null,
  public val iconUnckd: HciIcon? = null,
  public val descrs: List<HciGroupName> = emptyList(),
  public val gisFltrL: List<HciGisFilter> = emptyList(),
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val names: List<HciGroupName> = emptyList(),
  public val subgroupL: List<HciGroup> = emptyList(),
  public val enabled: Boolean = true,
  public val subGrSelMode: HciSubGroupSelectionMode = HciSubGroupSelectionMode.U,
)
