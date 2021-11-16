package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.Journey
import de.jlnstrk.transit.util.response.base.ServiceResult

public data class StationBoardData(
    public val dateTime: OffsetDateTime?,
    public val isArrivalBoard: Boolean,
    public val journeys: List<Journey>
) : ServiceResult.Data