package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.NetworkMap
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class NetworkMapsData(
    override val header: DataHeader,
    public val maps: List<NetworkMap>,
    override val scrollContext: ScrollContext<NetworkMapsData>? = null
) : ServiceResult.Data, ScrollableData<NetworkMapsData>