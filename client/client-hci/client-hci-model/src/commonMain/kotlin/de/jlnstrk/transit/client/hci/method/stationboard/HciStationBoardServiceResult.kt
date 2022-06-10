package de.jlnstrk.transit.client.hci.method.stationboard

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.HciStationBoardType
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyGroup
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciStationBoardServiceResult(
  public val common: HciCommon? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val planrtTS: String? = null,
  public val sD: String? = null,
  public val sT: String? = null,
  public val globMsgL: List<HciMessage> = emptyList(),
  public val jnyGrpL: List<HciJourneyGroup> = emptyList(),
  public val jnyL: List<HciJourney> = emptyList(),
  public val locRefL: List<Int> = emptyList(),
  public val type: HciStationBoardType = HciStationBoardType.DEP,
) : HciServiceResult()
