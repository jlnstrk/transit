package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.client.efa.model.EfaJourney
import de.jlnstrk.transit.client.efa.request.EfaDateTimeMode
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.stop.Stop
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaJourney.normalize(provider: EfaProvider, mode: EfaDateTimeMode): Journey {
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
        id = servingLine.stateless,
        line = servingLine.normalize(provider, operator),
        directionFrom = Location.Station(
            name = servingLine.directionFrom
        ),
        directionTo = Location.Station(
            numericId = servingLine.destID,
            name = servingLine.direction
        ),
        stop = when (mode) {
            EfaDateTimeMode.ARRIVAL -> Stop.Arrival(
                location = stopLocation,
                arrivalScheduled = zonedDateTime,
                arrivalRealtime = zonedRealtimeDateTime,
                arrivalScheduledPlatform = platformName,
                arrivalCancelled = cancelled,
                index = null,
                arrivalRealtimePlatform = null
            )
            EfaDateTimeMode.DEPARTURE,
            EfaDateTimeMode.FIRST_SERVICE,
            EfaDateTimeMode.LAST_SERVICE -> Stop.Departure(
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