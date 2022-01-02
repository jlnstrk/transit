package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFilter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciRequestConfigGroup(
  public val details: Boolean = false,
  public val historical: Boolean = false,
  public val realTrainname: Boolean = false,
  public val realtime: Boolean = false,
  public val reqJourneyDetails: Boolean = false,
  public val reqJourneyMatch: Boolean = false,
  public val reqStationBoard: Boolean = false,
  public val show: Boolean = false,
  public val showConst: Boolean = false,
  public val showDist: Boolean = false,
  public val showDowntime: Boolean = false,
  public val showForeignTrains: Boolean = false,
  public val trainDelays: String? = null,
  public val trainNameMode: String? = null,
  public val trainname: Boolean = false,
  public val jnyFltrL: List<HciJourneyFilter> = emptyList(),
  public val id: Int = -1
)
