package de.jlnstrk.transit.client.hci.method.journeymatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyMatchGroup
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyMatchResultStatus
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyMatchServiceResult(
  public val common: HciCommon? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val lineXml: String? = null,
  public val planrtTS: String? = null,
  public val groups: List<HciJourneyMatchGroup> = emptyList(),
  public val jnyL: List<HciJourney> = emptyList(),
  public val resultStatus: HciJourneyMatchResultStatus = HciJourneyMatchResultStatus.OK,
) : HciServiceResult()
