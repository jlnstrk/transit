package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.model.Trip
import de.jlnstrk.transit.util.response.base.ServiceResult

public class TripRefreshData(
    public val trip: Trip
) : ServiceResult.Data