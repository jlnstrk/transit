package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class LocationListData(
    override val header: DataHeader,
    public val locations: List<Location>,
    override val scrollContext: ScrollContext<LocationListData>? = null
) : ServiceResult.Data, ScrollableData<LocationListData>