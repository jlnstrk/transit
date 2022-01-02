package de.jlnstrk.transit.interop.hci.conversion

import com.soywiz.klock.DateTime
import com.soywiz.klock.days
import com.soywiz.klock.plus
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import de.jlnstrk.transit.common.model.stop.Stop
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.ZoneOffset

internal fun HciJourneyStop.arrivalAsCommon(context: HciCommonContext, date: LocalDate): Stop.Arrival {
    val arrivalTimezone = aTZOffset?.let { ZoneOffset(context.timezone.time + it.time) } ?: context.timezone
    return Stop.Arrival(
        location = context.locations[locX!!],
        index = idx,
        arrivalScheduled = DateTime(date.plus((aTimeS?.offsetDays?.toLong() ?: 0L).days), aTimeS!!.time)
            .toOffsetUnadjusted(arrivalTimezone),
        arrivalRealtime = aTimeR?.let {
            DateTime(date.plus(it.offsetDays.toLong().days), it.time)
                .toOffsetUnadjusted(arrivalTimezone)
        },
        arrivalScheduledPlatform = aPltfS?.txt ?: aPlatfS,
        arrivalRealtimePlatform = aPltfR?.txt ?: aPlatfR,
        arrivalCancelled = aCncl ?: false
    )
}

internal fun HciJourneyStop.departureAsCommon(context: HciCommonContext, date: LocalDate): Stop.Departure {
    val departureTimezone = dTZOffset?.let { ZoneOffset(context.timezone.time + it.time) } ?: context.timezone
    return Stop.Departure(
        location = context.locations[locX!!],
        index = idx,
        departureScheduled = DateTime(
            date.plus((dTimeS?.offsetDays?.toLong() ?: 0L).days),
            dTimeS!!.time
        ).toOffsetUnadjusted(departureTimezone),
        departureRealtime = dTimeR?.let {
            DateTime(
                date.plus(it.offsetDays.toLong().days),
                it.time
            ).toOffsetUnadjusted(departureTimezone)
        },
        departureScheduledPlatform = dPltfS?.txt ?: dPlatfS,
        departureRealtimePlatform = dPltfR?.txt ?: dPlatfR,
        departureCancelled = dCncl ?: false
    )
}

internal fun HciJourneyStop.intermediateAsCommon(context: HciCommonContext, date: LocalDate): Stop.Intermediate {
    val arrivalTimezone = aTZOffset?.let { ZoneOffset(context.timezone.time + it.time) } ?: context.timezone
    val departureTimezone = dTZOffset?.let { ZoneOffset(context.timezone.time + it.time) } ?: context.timezone
    return Stop.Intermediate(
        location = context.locations[locX!!],
        index = idx,
        arrivalScheduled = DateTime(
            date.plus((aTimeS?.offsetDays?.toLong() ?: 0L).days),
            aTimeS!!.time
        ).toOffsetUnadjusted(arrivalTimezone),
        arrivalRealtime = aTimeR?.let {
            DateTime(date.plus(it.offsetDays.toLong().days), it.time)
                .toOffsetUnadjusted(arrivalTimezone)
        },
        arrivalScheduledPlatform = aPltfS?.txt ?: aPlatfS,
        arrivalRealtimePlatform = aPltfR?.txt ?: aPlatfR,
        arrivalCancelled = aCncl,
        departureScheduled = DateTime(
            date.plus((dTimeS?.offsetDays?.toLong() ?: 0L).days),
            dTimeS!!.time
        ).toOffsetUnadjusted(departureTimezone),
        departureRealtime = dTimeR?.let {
            DateTime(
                date.plus(it.offsetDays.toLong().days),
                it.time
            ).toOffsetUnadjusted(departureTimezone)
        },
        departureScheduledPlatform = dPltfS?.txt ?: dPlatfS,
        departureRealtimePlatform = dPltfR?.txt ?: dPlatfR,
        departureCancelled = dCncl ?: false
    )
}

internal fun HciJourneyStop.asCommon(context: HciCommonContext, date: LocalDate): Stop {
    return when {
        aTimeS != null && dTimeS != null -> intermediateAsCommon(context, date)
        aTimeS != null -> arrivalAsCommon(context, date)
        dTimeS != null -> departureAsCommon(context, date)
        else -> Stop.Passing(
            location = context.locations[locX!!],
            index = idx
        )
    }
}