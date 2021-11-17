package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.LineGeometry
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class NetworkGeometryData(
    override val header: DataHeader,
    public val geometries: Map<ProductClass, List<LineGeometry>>
) : ServiceResult.Data