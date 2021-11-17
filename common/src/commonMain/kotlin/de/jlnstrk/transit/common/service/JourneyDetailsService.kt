package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.Journey
import de.jlnstrk.transit.util.model.Location

public interface JourneyDetailsService : Service {
    public val supportsStartIndex: Boolean get() = false
    public val supportsStartLocation: Boolean get() = false
    public val supportsEndIndex: Boolean get() = false
    public val supportsEndLocation: Boolean get() = false
    public val supportsIncludeStops: Boolean get() = false
    public val supportsIncludePassedStops: Boolean get() = false
    public val supportsIncludePolyline: Boolean get() = false
    public val supportsIncludeComposition: Boolean get() = false

    public suspend fun journeyDetails(
        journey: Journey,
        startIndex: Int? = null,
        startLocation: Location? = null,
        endIndex: Int? = null,
        endLocation: Location? = null,
        includeStops: Boolean? = null,
        includePassedStops: Boolean? = null,
        includePolyline: Boolean? = null,
        includeComposition: Boolean? = null
    ): JourneyDetailsResult

    public enum class Error {
        INVALID_JOURNEY,
        INVALID_INDEX,
        INVALID_LOCATION
    }
}