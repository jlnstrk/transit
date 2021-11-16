package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass

public interface LocationSearchService : Service {
    public val supportsFilterTypes: Boolean get() = false
    public val supportsFilterProducts: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun locationSearch(
        query: String,
        filterTypes: Set<Location.Type>? = null,
        filterProducts: Set<ProductClass>? = null,
        maxResults: Int? = null
    ): LocationSearchResult

    public enum class Error {
        QUERY_TOO_SHORT,
        QUERY_TOO_LONG
    }
}