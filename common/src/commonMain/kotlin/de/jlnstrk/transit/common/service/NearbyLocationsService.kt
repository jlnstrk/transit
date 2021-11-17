package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.*

public interface NearbyLocationsService : Service {
    public val supportsFilterTypes: Boolean get() = false
    public val supportsFilterProducts: Boolean get() = false
    public val supportsFilterAttributes: Boolean get() = false
    public val supportsMinDistance: Boolean get() = false
    public val supportsMaxDistance: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun nearbyLocations(
        coordinates: Coordinates,
        filterTypes: Set<Location.Type>? = null,
        filterProducts: Set<ProductClass>? = null,
        filterAttributes: Set<Attribute>? = null,
        minDistance: Int? = null,
        maxDistance: Int? = null,
        maxResults: Int? = null
    ): NearbyLocationsResult

    public enum class Error {
        INVALID_LOCATION
    }
}