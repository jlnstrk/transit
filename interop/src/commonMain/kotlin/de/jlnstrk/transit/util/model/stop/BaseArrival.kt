package de.jlnstrk.transit.util.model.stop

import de.jlnstrk.transit.util.OffsetDateTime

public interface BaseArrival {
    public val arrivalScheduled: OffsetDateTime
    public val arrivalScheduledPlatform: String?
    public val arrivalRealtime: OffsetDateTime?
    public val arrivalRealtimePlatform: String?
    public val arrivalCancelled: Boolean
}