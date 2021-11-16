package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.model.NetworkMap
import de.jlnstrk.transit.util.response.base.ScrollContext
import de.jlnstrk.transit.util.response.base.ScrollableData
import de.jlnstrk.transit.util.response.base.ServiceResult

public class NetworkMapsData(
    public val maps: List<NetworkMap>,
    override val scrollContext: ScrollContext<NetworkMapsData>? = null
) : ServiceResult.Data, ScrollableData<NetworkMapsData>