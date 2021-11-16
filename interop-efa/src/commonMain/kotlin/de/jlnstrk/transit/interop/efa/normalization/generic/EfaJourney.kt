package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.model.EfaJourney
import de.jlnstrk.transit.api.efa.request.EfaRequest
import de.jlnstrk.transit.util.model.Journey
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.stop.Stop
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaJourney.normalize(provider: EfaProvider, mode: EfaRequest.DateTimeMode): Journey {
    val stopLocation = Location.Station(
        name = stopName,
        coordinates = EfaCoordinates(x, y, mapName).normalized(),
        numericId = stopID
    )
    val zonedDateTime = dateTime.toOffsetUnadjusted(provider.timezone)
    val zonedRealtimeDateTime = realDateTime?.toOffsetUnadjusted(provider.timezone)
    val cancelled = false
    return Journey(
        // Not unique!
        literalId = servingLine.stateless,
        // (Hopefully) unique!
        numericId = servingLine.key,
        line = servingLine.normalize(provider, operator),
        directionFrom = Location.Station(
            name = servingLine.directionFrom
        ),
        directionTo = Location.Station(
            numericId = servingLine.destID,
            name = servingLine.direction
        ),
        stop = when (mode) {
            EfaRequest.DateTimeMode.ARRIVAL -> Stop.Arrival(
                location = stopLocation,
                arrivalScheduled = zonedDateTime,
                arrivalRealtime = zonedRealtimeDateTime,
                arrivalScheduledPlatform = platformName,
                arrivalCancelled = cancelled,
                index = null,
                arrivalRealtimePlatform = null
            )
            EfaRequest.DateTimeMode.DEPARTURE,
            EfaRequest.DateTimeMode.FIRST_SERVICE,
            EfaRequest.DateTimeMode.LAST_SERVICE -> Stop.Departure(
                location = stopLocation,
                departureScheduled = zonedDateTime,
                departureRealtime = zonedRealtimeDateTime,
                departureScheduledPlatform = platformName,
                departureCancelled = cancelled,
                index = null,
                departureRealtimePlatform = null
            )
        }
    )
}