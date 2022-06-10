package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.*
import de.jlnstrk.transit.common.response.TripSearchData
import de.jlnstrk.transit.common.response.base.ScrollContext
import kotlinx.datetime.Instant
import kotlin.time.Duration

public interface TripSearchService : Service {
    public val supportedOriginTypes: Set<Location.Type>
    public val supportedDestinationTypes: Set<Location.Type>
    public val supportedViaTypes: Set<Location.Type>
    public val supportedViaCount: Int

    public val supportsDateTime: Boolean get() = false
    public val supportsDateTimeMode: Boolean get() = false
    public val supportsFilterProducts: Boolean get() = false
    public val supportsFilterLines: Boolean get() = false
    public val supportsIncludePolylines: Boolean get() = false
    public val supportsIncludeStops: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun tripSearch(
        origin: Location,
        destination: Location,
        via: List<Via> = emptyList(),
        viaPeriod: Duration? = null,
        viaModes: Set<Via.Mode>? = null,
        dateTime: Instant? = null,
        dateTimeIsArrival: Boolean? = null,
        filterProducts: ProductSet? = null,
        filterLines: LineSet? = null,
        includePolylines: Boolean? = null,
        includeStops: Boolean? = null,
        maxResults: Int? = null,
    ): TripSearchResult

    public suspend fun tripSearchScroll(
        scrollContext: ScrollContext<TripSearchData>,
        scrollBackward: Boolean
    ): TripSearchResult

    public enum class Error {
        INVALID_LOCATION,
        INVALID_ORIGIN,
        INVALID_DESTINATION,
        INVALID_VIA,
        INVALID_DATETIME,
        TOO_CLOSE,
    }
}