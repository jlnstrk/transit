package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.util.model.Trip
import de.jlnstrk.transit.util.response.base.ScrollContext
import de.jlnstrk.transit.util.response.base.ServiceResult

public class TripSearchData(
    public var trips: List<Trip>,
    public val scrollContext: ScrollContext<TripSearchData>? = null
) : ServiceResult.Data