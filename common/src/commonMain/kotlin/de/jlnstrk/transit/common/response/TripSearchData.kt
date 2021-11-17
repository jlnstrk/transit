package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class TripSearchData(
    override val header: DataHeader,
    public val trips: List<Trip>,
    override val scrollContext: ScrollContext<TripSearchData>?
) : ServiceResult.Data, ScrollableData<TripSearchData>