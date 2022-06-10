package de.jlnstrk.transit.common.model.stop

import kotlinx.datetime.Instant

public interface BaseDeparture {
    public val departureScheduled: Instant
    public val departureScheduledPlatform: String?
    public val departureRealtime: Instant?
    public val departureRealtimePlatform: String?
    public val departureCancelled: Boolean
}