package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.client.efa.model.EfaStop
import de.jlnstrk.transit.common.model.Coordinates
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.stop.Stop
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toInstant
import kotlin.time.Duration

internal fun EfaStop.normalizeAsDeparture(
    provider: EfaProvider,
    isRealtime: Boolean
): Stop.Departure {
    return Stop.Departure(
        location = normalizeAsLocation(provider),
        departureScheduled = LocalDateTime(
            stamp!!.date,
            stamp!!.time
        ).toInstant(provider.timezone),
        departureRealtime = stamp?.rtDate
            ?.takeIf { isRealtime }
            ?.let { LocalDateTime(it, stamp!!.rtTimeSec).toInstant(provider.timezone) },
        departureCancelled = false,
        departureScheduledPlatform = plannedPlatformName ?: platformName,
        departureRealtimePlatform = platformName,
        index = null
    )
}

internal fun EfaStop.normalizeAsArrival(provider: EfaProvider, isRealtime: Boolean): Stop.Arrival {
    return Stop.Arrival(
        location = normalizeAsLocation(provider),
        arrivalScheduled = LocalDateTime(stamp!!.date, stamp!!.time)
            .toInstant(provider.timezone),
        arrivalRealtime = stamp?.rtDate
            ?.takeIf { isRealtime }
            ?.let {
                LocalDateTime(it, stamp!!.rtTimeSec)
                    .toInstant(provider.timezone)
            },
        arrivalCancelled = false,
        arrivalScheduledPlatform = plannedPlatformName ?: platformName,
        arrivalRealtimePlatform = platformName,
        index = null
    )
}

internal fun EfaStop.normalizeAsIntermediate(provider: EfaProvider): Stop {
    val departureScheduled = ref.depDateTimeSec?.toInstant(provider.timezone)
    val departureCancelled =
        ref.depValid && ref.depDelay?.inWholeMinutes == -9999L
    val departureRealtime = departureScheduled
        ?.plus(ref.depDelay ?: Duration.ZERO)
        ?.takeUnless { !ref.depValid || departureCancelled }
    val arrivalScheduled = ref.arrDateTimeSec?.toInstant(provider.timezone)
    val arrivalCancelled =
        ref.arrValid && ref.arrDelay?.inWholeMinutes == -9999L
    val arrivalRealtime = arrivalScheduled
        ?.plus(ref.arrDelay ?: Duration.ZERO)
        ?.takeUnless { !ref.arrValid || arrivalCancelled }

    val location = normalizeAsLocation(provider)
    return when {
        departureScheduled != null
                && arrivalScheduled != null -> Stop.Intermediate(
            location,
            departureScheduled = departureScheduled,
            departureRealtime = departureRealtime,
            departureScheduledPlatform = platformName,
            departureRealtimePlatform = null,
            departureCancelled = departureCancelled,
            arrivalScheduled = arrivalScheduled,
            arrivalRealtime = arrivalRealtime,
            arrivalScheduledPlatform = platformName,
            arrivalRealtimePlatform = null,
            arrivalCancelled = arrivalCancelled,
            index = null
        )
        departureScheduled != null -> Stop.Departure(
            location,
            departureScheduled = departureScheduled,
            departureRealtime = null,
            departureScheduledPlatform = platformName,
            departureRealtimePlatform = null,
            departureCancelled = !ref.depValid,
            index = null
        )
        arrivalScheduled != null -> Stop.Arrival(
            location,
            arrivalScheduled = arrivalScheduled,
            arrivalRealtime = null,
            arrivalScheduledPlatform = platformName,
            arrivalRealtimePlatform = null,
            arrivalCancelled = !ref.arrValid,
            index = null
        )
        else -> Stop.Passing(location, index = null)
    }
}

internal fun EfaStop.normalizeAsLocation(provider: EfaProvider): Location {
    return Location.Station(
        name = name.orEmpty(),
        place = place,
        coordinates = ref.coords?.normalized() ?: Coordinates(Double.NaN, Double.NaN),
        id = ref.id.toString(),
        products = null,
        lines = null,
        weight = null,
        isSubStation = false
    )
}