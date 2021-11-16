package de.jlnstrk.transit.util.model.stop

import de.jlnstrk.transit.util.OffsetDateTime

public interface BaseDeparture {
    public val departureScheduled: OffsetDateTime
    public val departureScheduledPlatform: String?
    public val departureRealtime: OffsetDateTime?
    public val departureRealtimePlatform: String?
    public val departureCancelled: Boolean
}