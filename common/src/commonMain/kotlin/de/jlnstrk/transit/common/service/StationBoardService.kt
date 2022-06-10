package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.ProductClass
import kotlinx.datetime.Instant
import kotlin.time.Duration

public interface StationBoardService : Service {
    public val supportedModes: Set<Mode> get() = emptySet()
    public val supportedLocationTypes: Set<Location.Type> get() = emptySet()

    public val supportsDateTime: Boolean get() = false
    public val supportsFilterDirection: Boolean get() = false
    public val supportsFilterProducts: Boolean get() = false
    public val supportsFilterLines: Boolean get() = false
    public val supportsFilterOperators: Boolean get() = false
    public val supportsMaxDuration: Boolean get() = false
    public val supportsMaxResults: Boolean get() = false

    public suspend fun stationBoard(
        mode: Mode,
        location: Location,
        direction: Location? = null,
        dateTime: Instant? = null,
        filterProducts: Set<ProductClass>? = null,
        filterLines: Set<Line>? = null,
        maxDuration: Duration? = null,
        maxResults: Int? = null,
    ): StationBoardResult

    public enum class Mode {
        DEPARTURES,
        ARRIVALS
    }

    public enum class Error {
        INVALID_LOCATION,
        INVALID_DATETIME
    }
}