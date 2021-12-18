package de.jlnstrk.transit.client.hci.method.stationboard

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciJourneyGroup
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.response.HciTimeAwareResponse
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciStationBoardResult(
    public val type: HciStationBoardRequest.Type?,
    public val jnyL: List<HciJourney> = emptyList(),
    public val jnyGrpL: List<HciJourneyGroup> = emptyList(),
    public val globMsgL: List<HciMessage> = emptyList(),
    public val locRefL: List<Int> = emptyList(),
) : HciTimeAwareResponse()