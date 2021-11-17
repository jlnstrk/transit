package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.response.base.ScrollContext
import de.jlnstrk.transit.util.response.base.ScrollResult
import de.jlnstrk.transit.util.response.base.ScrollableData
import de.jlnstrk.transit.util.response.base.ServiceResult

public data class LocationListData(
    public val locations: List<Location>,
    override val scrollContext: ScrollContext<LocationListData>? = null
) : ServiceResult.Data, ScrollableData<LocationListData> {

    override fun mergeWith(scrollData: ScrollResult<LocationListData>): LocationListData {
        return LocationListData(
            locations = locations + scrollData.data.locations,
            scrollContext = scrollContext // TODO
        )
    }
}