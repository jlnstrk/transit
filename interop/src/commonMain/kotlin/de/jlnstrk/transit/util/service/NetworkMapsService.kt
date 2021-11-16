package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.ProductClass

public interface NetworkMapsService : Service {
    public val supportsFilterProducts: Boolean get() = false

    public suspend fun networkMaps(
        name: String? = null,
        filterProducts: Set<ProductClass>? = null
    ): NetworkMapsResult

    public enum class Error
}