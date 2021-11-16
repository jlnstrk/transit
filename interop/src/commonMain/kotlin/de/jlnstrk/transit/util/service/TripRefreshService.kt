package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.Service
import de.jlnstrk.transit.util.model.Trip

public interface TripRefreshService : Service {

    public suspend fun tripRefresh(
        context: Trip.RefreshContext,
        includeStops: Boolean? = null,
        includePassedStops: Boolean? = null,
        includePolylines: Boolean? = null
    ): TripRefreshResult

    public enum class Error
}