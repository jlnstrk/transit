package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class JourneyListData(
    override val header: DataHeader,
    public val journeys: List<Journey>,
    override val scrollContext: ScrollContext<JourneyListData>?,
) : ServiceResult.Data, ScrollableData<JourneyListData>