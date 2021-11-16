package de.jlnstrk.transit.util.model.stop

import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.util.model.Location

public sealed class Stop {
    public abstract val location: Location
    public abstract val index: Int?

    public data class Departure(
        override val location: Location,
        override val index: Int?,
        override val departureScheduled: OffsetDateTime,
        override val departureScheduledPlatform: String?,
        override val departureRealtime: OffsetDateTime?,
        override val departureRealtimePlatform: String?,
        override val departureCancelled: Boolean
    ) : Stop(), BaseDeparture

    public data class Arrival(
        override val location: Location,
        override val index: Int?,
        override val arrivalScheduled: OffsetDateTime,
        override val arrivalScheduledPlatform: String?,
        override val arrivalRealtime: OffsetDateTime?,
        override val arrivalRealtimePlatform: String?,
        override val arrivalCancelled: Boolean
    ) : Stop(), BaseArrival

    public data class Intermediate(
        override val location: Location,
        override val index: Int?,
        override val arrivalScheduled: OffsetDateTime,
        override val arrivalScheduledPlatform: String?,
        override val arrivalRealtime: OffsetDateTime?,
        override val arrivalRealtimePlatform: String?,
        override val arrivalCancelled: Boolean,
        override val departureScheduled: OffsetDateTime,
        override val departureScheduledPlatform: String?,
        override val departureRealtime: OffsetDateTime?,
        override val departureRealtimePlatform: String?,
        override val departureCancelled: Boolean
    ) : Stop(), BaseArrival, BaseDeparture

    public data class Passing(
        override val location: Location,
        override val index: Int?
    ) : Stop()
}