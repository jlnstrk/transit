package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult
import kotlinx.datetime.Instant

public data class StationBoardData(
    override val header: DataHeader,
    public val dateTime: Instant?,
    public val isArrivalBoard: Boolean,
    public val journeys: List<Journey>,
    override val scrollContext: ScrollContext<StationBoardData>?,
) : ServiceResult.Data, ScrollableData<StationBoardData>