package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.Area
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.ProductSet
import kotlin.jvm.JvmOverloads

public interface JourneyPositionsService : Service {
    public val supportsBoundingBox: Boolean get() = false
    public val supportsRadius: Boolean get() = false

    public val supportsFilterProducts: Boolean get() = false
    public val supportsFilterLines: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun journeyPositions(
        area: Area,
        filterProducts: ProductSet? = null,
        filterLines: LineSet? = null,
        maxResults: Int? = null,
    ):  JourneyPositionsResult

    public enum class Error {
        AREA_OUTSIDE_OF_NETWORK,
    }
}