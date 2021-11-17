package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.ProductClass

public interface NetworkMapsService : Service {
    public val supportsFilterProducts: Boolean get() = false

    public suspend fun networkMaps(
        name: String? = null,
        filterProducts: Set<ProductClass>? = null
    ): NetworkMapsResult

    public enum class Error
}