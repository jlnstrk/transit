package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.model.LineGeometry
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.base.ServiceResult

public class NetworkGeometryData(
    public val geometries: Map<ProductClass, List<LineGeometry>>
) : ServiceResult.Data