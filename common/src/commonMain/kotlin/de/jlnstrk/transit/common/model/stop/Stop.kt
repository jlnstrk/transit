package de.jlnstrk.transit.common.model.stop

import de.jlnstrk.transit.common.model.Location
import kotlinx.datetime.Instant

public sealed class Stop {
    public abstract val location: Location
    public abstract val index: Int?

    public data class Departure(
        override val location: Location,
        override val index: Int?,
        override val departureScheduled: Instant,
        override val departureScheduledPlatform: String?,
        override val departureRealtime: Instant?,
        override val departureRealtimePlatform: String?,
        override val departureCancelled: Boolean
    ) : Stop(), BaseDeparture

    public data class Arrival(
        override val location: Location,
        override val index: Int?,
        override val arrivalScheduled: Instant,
        override val arrivalScheduledPlatform: String?,
        override val arrivalRealtime: Instant?,
        override val arrivalRealtimePlatform: String?,
        override val arrivalCancelled: Boolean
    ) : Stop(), BaseArrival

    public data class Intermediate(
        override val location: Location,
        override val index: Int?,
        override val arrivalScheduled: Instant,
        override val arrivalScheduledPlatform: String?,
        override val arrivalRealtime: Instant?,
        override val arrivalRealtimePlatform: String?,
        override val arrivalCancelled: Boolean,
        override val departureScheduled: Instant,
        override val departureScheduledPlatform: String?,
        override val departureRealtime: Instant?,
        override val departureRealtimePlatform: String?,
        override val departureCancelled: Boolean
    ) : Stop(), BaseArrival, BaseDeparture

    public data class Passing(
        override val location: Location,
        override val index: Int?
    ) : Stop()
}