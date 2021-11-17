package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class TripRefreshData(
    override val header: DataHeader,
    public val trip: Trip
) : ServiceResult.Data