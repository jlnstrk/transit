package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.util.model.Trip
import de.jlnstrk.transit.util.response.base.ServiceResult

public class TripRefreshData(
    public val trip: Trip
) : ServiceResult.Data