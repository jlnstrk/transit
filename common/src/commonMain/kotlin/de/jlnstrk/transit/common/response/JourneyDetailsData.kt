package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class JourneyDetailsData(
    override val header: DataHeader,
    public val journey: Journey,
) : ServiceResult.Data