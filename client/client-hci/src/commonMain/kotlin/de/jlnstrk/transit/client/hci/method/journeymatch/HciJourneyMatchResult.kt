package de.jlnstrk.transit.client.hci.method.journeymatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciJourneyMatchGroup
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.response.HciScheduleResult
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciJourneyMatchResult(
    public val groups: List<HciJourneyMatchGroup> = emptyList(),
    public val jnyL: List<HciJourney> = emptyList(),
    public val lineXml: String?,
    public val resultStatus: Status?,
) : HciScheduleResult() {

    @HciModel("1.39")
    @Serializable
    public enum class Status {
        LIMIT_EXCEEDED,
        OK,
    }
}