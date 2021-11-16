package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.model.Via
import de.jlnstrk.transit.util.response.TripSearchData
import de.jlnstrk.transit.util.response.base.ScrollContext

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

        via: List<Via>? = null,
        viaPeriod: Duration? = null,
        viaModes: Set<Via.Mode>? = null,

        dateTime: OffsetDateTime? = null,
        dateTimeIsArrival: Boolean? = null,

        filterProducts: Set<ProductClass>? = null,
        filterLines: Set<Line>? = null,

        includePolylines: Boolean? = null,
        includeStops: Boolean? = null,
        maxResults: Int? = null,
    ): TripSearchResult

    public suspend fun tripSearchScroll(
        scrollContext: ScrollContext<TripSearchData>,
        scrollBackward: Boolean
    ): TripSearchResult

    public enum class Capability {

        /** The service supports addresses, [ADDRESSES], and/or POIs, [POIS],
         *  for origin, destination and via. */
        ADDRESSES,
        POIS,

        /** The service supports single, [VIA],
         * or multiple, [VIA_MULTIPLE], via. */
        VIA,
        VIA_MULTIPLE,

        /** The service supports wait times for all, [VIA_PERIOD],
         * and/or per individual, [VIA_PERIOD_INDIVIDUAL], via. */
        VIA_PERIOD,
        VIA_PERIOD_INDIVIDUAL,

        /** The service handles modes for all, [VIA_MODE],
         * and/or per individual, [VIA_MODE_INDIVIDUAL], via.
         * See [Via.Mode], [Via.modes]. */
        VIA_MODE,
        VIA_MODE_INDIVIDUAL,

        /** The service supports specifying a trip datetime, [TIME],
         * that the time is to be regarded as arrival time, [TIME_ARRIVAL]. */
        TIME,
        TIME_ARRIVAL,

        /** The service supports specifying the number of returned trips
         * relative to the passed datetime. */
        TIME_NUM_BEFORE,
        TIME_NUM_AFTER,

        /** The service supports filtering trips based on the products used. */
        FILTER_PRODUCTS,

        /** The service supports filtering trips based on the lines used. */
        FILTER_LINES,

        /** The service supports returning polylines for journeys */
        INCLUDE_POLYLINES,

        /** The service supports returning passing stops for journeys */
        INCLUDE_STOPS

    }

    public enum class Error {
        INVALID_LOCATION,
        INVALID_ORIGIN,
        INVALID_DESTINATION,
        INVALID_VIA,
        INVALID_DATETIME,
        TOO_CLOSE
    }
}