package de.jlnstrk.transit.api.hci.method.stationboard

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciJourneyGroup
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.response.HciTimeAwareResponse
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