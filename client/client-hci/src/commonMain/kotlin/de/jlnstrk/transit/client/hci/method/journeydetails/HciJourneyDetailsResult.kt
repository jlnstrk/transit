package de.jlnstrk.transit.client.hci.method.journeydetails

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.client.hci.response.HciScheduleResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public class HciJourneyDetailsResult(
    /** The journey with details */
    public val journey: HciJourney,
    /** Global messages applying to this journey */
    public val globMsgL: List<HciMessage> = emptyList(),
) : HciScheduleResult()