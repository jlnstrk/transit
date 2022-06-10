package de.jlnstrk.transit.common.util

import de.jlnstrk.transit.common.model.Leg
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.common.model.stop.BaseArrival
import de.jlnstrk.transit.common.model.stop.BaseDeparture
import kotlinx.datetime.Instant
import kotlin.time.Duration

public inline val BaseArrival.isArrivalEarly: Boolean
    get() = arrivalRealtime != null
            && arrivalRealtime!! < arrivalScheduled

public inline val BaseArrival.arrivalAdvance: Duration
    get() = arrivalRealtime?.let { arrivalScheduled - it }
        ?: Duration.ZERO

public inline val BaseArrival.isArrivalDelayed: Boolean
    get() = arrivalRealtime != null
            && arrivalRealtime!! > arrivalScheduled

public inline val BaseArrival.arrivalDelay: Duration
    get() = arrivalRealtime?.let { it - arrivalScheduled }
        ?: Duration.ZERO

public inline val BaseDeparture.isDepartureEarly: Boolean
    get() = departureRealtime != null
            && departureRealtime!! < departureScheduled

public inline val BaseDeparture.departureAdvance: Duration
    get() = departureRealtime?.let { departureScheduled - it }
        ?: Duration.ZERO

public inline val BaseDeparture.isDepartureDelayed: Boolean
    get() = departureRealtime != null
            && departureRealtime!! > departureScheduled

public inline val BaseDeparture.departureDelay: Duration
    get() = departureRealtime?.let { it - departureScheduled }
        ?: Duration.ZERO

public inline val BaseArrival.arrivalEffective: Instant
    get() = arrivalRealtime ?: arrivalScheduled

public inline val BaseDeparture.departureEffective: Instant
    get() = departureRealtime ?: departureScheduled

public inline val Trip.scheduledDuration: Duration
    get() = arrival.arrivalScheduled - departure.departureScheduled

public inline val Trip.realtimeDuration: Duration
    get() = (arrival.arrivalRealtime ?: arrival.arrivalScheduled) - (departure.departureRealtime
        ?: departure.departureScheduled)

public inline val Leg.scheduledDuration: Duration
    get() = arrival.arrivalScheduled - departure.departureScheduled

public inline val Leg.realtimeDuration: Duration
    get() = (arrival.arrivalRealtime ?: arrival.arrivalScheduled) - (departure.departureRealtime
        ?: departure.departureScheduled)