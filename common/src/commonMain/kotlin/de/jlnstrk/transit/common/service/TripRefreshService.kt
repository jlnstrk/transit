package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service
import de.jlnstrk.transit.common.model.Trip

public interface TripRefreshService : Service {

    public suspend fun tripRefresh(
        context: Trip.RefreshContext,
        includeStops: Boolean? = null,
        includePassedStops: Boolean? = null,
        includePolylines: Boolean? = null
    ): TripRefreshResult

    public enum class Error
}