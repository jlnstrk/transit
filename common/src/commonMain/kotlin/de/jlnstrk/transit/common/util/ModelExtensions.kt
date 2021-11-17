package de.jlnstrk.transit.common.util

import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime
import de.jlnstrk.transit.common.model.Leg
import de.jlnstrk.transit.common.model.Trip
import de.jlnstrk.transit.common.model.stop.BaseArrival
import de.jlnstrk.transit.common.model.stop.BaseDeparture
import de.jlnstrk.transit.util.until

public inline val BaseArrival.isArrivalEarly: Boolean
    get() = arrivalRealtime != null
            && arrivalRealtime!! < arrivalScheduled

public inline val BaseArrival.arrivalAdvance: Duration
    get() = arrivalRealtime?.let { it until arrivalScheduled }
        ?: Duration.ZERO

public inline val BaseArrival.isArrivalDelayed: Boolean
    get() = arrivalRealtime != null
            && arrivalRealtime!! > arrivalScheduled

public inline val BaseArrival.arrivalDelay: Duration
    get() = arrivalRealtime?.let { arrivalScheduled until it }
        ?: Duration.ZERO

public inline val BaseDeparture.isDepartureEarly: Boolean
    get() = departureRealtime != null
            && departureRealtime!! < departureScheduled

public inline val BaseDeparture.departureAdvance: Duration
    get() = departureRealtime?.let { it until departureScheduled }
        ?: Duration.ZERO

public inline val BaseDeparture.isDepartureDelayed: Boolean
    get() = departureRealtime != null
            && departureRealtime!! > departureScheduled

public inline val BaseDeparture.departureDelay: Duration
    get() = departureRealtime?.let { departureScheduled until it }
        ?: Duration.ZERO

public inline val BaseArrival.arrivalEffective: OffsetDateTime
    get() = arrivalRealtime ?: arrivalScheduled

public inline val BaseDeparture.departureEffective: OffsetDateTime
    get() = departureRealtime ?: departureScheduled

public inline val Trip.scheduledDuration: Duration
    get() = departure.departureScheduled until arrival.arrivalScheduled

public inline val Trip.realtimeDuration: Duration
    get() = (departure.departureRealtime
        ?: departure.departureScheduled) until (arrival.arrivalRealtime ?: arrival.arrivalScheduled)

public inline val Leg.scheduledDuration: Duration
    get() = departure.departureScheduled until arrival.arrivalScheduled

public inline val Leg.realtimeDuration: Duration
    get() = (departure.departureRealtime ?: departure.departureScheduled) until
            (arrival.arrivalRealtime ?: arrival.arrivalScheduled)