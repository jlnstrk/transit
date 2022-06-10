package de.jlnstrk.transit.client.hci.method.journeydetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciJourneyDetailsServiceResult(
  public val common: HciCommon? = null,
  public val fpB: String? = null,
  public val fpE: String? = null,
  public val globMsgL: List<HciMessage> = emptyList(),
  public val journey: HciJourney? = null,
  public val planrtTS: String? = null,
) : HciServiceResult()
