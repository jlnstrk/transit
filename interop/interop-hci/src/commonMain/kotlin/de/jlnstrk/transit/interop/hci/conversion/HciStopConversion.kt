package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.journey.HciJourneyStop
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.common.model.stop.Stop
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import kotlinx.datetime.*

internal fun UtcOffset.plusZone(zone: TimeZone): FixedOffsetTimeZone {
    val combinedOffsetSeconds = zone.offsetAt(Clock.System.now()).totalSeconds + totalSeconds
    return FixedOffsetTimeZone(UtcOffset(seconds = combinedOffsetSeconds))
}

internal fun HciLocalTime.relativeTo(date: LocalDate): LocalDateTime {
    return LocalDateTime(date + DatePeriod(days = offsetDays), time)
}

internal fun HciJourneyStop.arrivalAsCommon(context: HciCommonContext, date: LocalDate): Stop.Arrival {
    val arrivalTimezone = aTZOffset?.plusZone(context.timezone) ?: context.timezone
    return Stop.Arrival(
        location = context.locations[locX!!],
        index = idx,
        arrivalScheduled = aTimeS!!.relativeTo(date).toInstant(arrivalTimezone),
        arrivalRealtime = aTimeR?.relativeTo(date)?.toInstant(arrivalTimezone),
        arrivalScheduledPlatform = aPltfS?.txt ?: aPlatfS,
        arrivalRealtimePlatform = aPltfR?.txt ?: aPlatfR,
        arrivalCancelled = aCncl ?: false
    )
}

internal fun HciJourneyStop.departureAsCommon(context: HciCommonContext, date: LocalDate): Stop.Departure {
    val departureTimezone = dTZOffset?.plusZone(context.timezone) ?: context.timezone
    return Stop.Departure(
        location = context.locations[locX!!],
        index = idx,
        departureScheduled = dTimeS!!.relativeTo(date).toInstant(departureTimezone),
        departureRealtime = dTimeR?.relativeTo(date)?.toInstant(departureTimezone),
        departureScheduledPlatform = dPltfS?.txt ?: dPlatfS,
        departureRealtimePlatform = dPltfR?.txt ?: dPlatfR,
        departureCancelled = dCncl ?: false
    )
}

internal fun HciJourneyStop.intermediateAsCommon(context: HciCommonContext, date: LocalDate): Stop.Intermediate {
    val arrivalTimezone = aTZOffset?.plusZone(context.timezone) ?: context.timezone
    val departureTimezone = dTZOffset?.plusZone(context.timezone) ?: context.timezone
    return Stop.Intermediate(
        location = context.locations[locX!!],
        index = idx,
        arrivalScheduled = aTimeS!!.relativeTo(date).toInstant(arrivalTimezone),
        arrivalRealtime = aTimeR?.relativeTo(date)?.toInstant(arrivalTimezone),
        arrivalScheduledPlatform = aPltfS?.txt ?: aPlatfS,
        arrivalRealtimePlatform = aPltfR?.txt ?: aPlatfR,
        arrivalCancelled = aCncl,
        departureScheduled = dTimeS!!.relativeTo(date).toInstant(departureTimezone),
        departureRealtime = dTimeR?.relativeTo(date)?.toInstant(departureTimezone),
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