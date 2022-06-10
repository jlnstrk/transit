package de.jlnstrk.transit.client.hci.method.journeystructgraphpos

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyStructGraphPosServiceResult(
  public val common: HciCommon? = null,
  public val jnyL: List<HciJourney> = emptyList(),
) : HciServiceResult()
