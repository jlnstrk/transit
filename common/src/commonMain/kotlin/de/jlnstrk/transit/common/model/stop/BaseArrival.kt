package de.jlnstrk.transit.common.model.stop

import kotlinx.datetime.Instant

public interface BaseArrival {
    public val arrivalScheduled: Instant
    public val arrivalScheduledPlatform: String?
    public val arrivalRealtime: Instant?
    public val arrivalRealtimePlatform: String?
    public val arrivalCancelled: Boolean
}