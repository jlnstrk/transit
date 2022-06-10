package de.jlnstrk.transit.util

import com.soywiz.klock.*
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlin.jvm.JvmInline

@JvmInline
public value class DateFormat internal constructor(private val formatter: com.soywiz.klock.DateFormat) {

    public fun format(instant: Instant): String = DateTimeTz.fromUnix(instant.toEpochMilliseconds()).format(formatter)

    public fun format(dateTime: LocalDateTime): String = DateTime.createAdjusted(
        dateTime.year,
        dateTime.monthNumber,
        dateTime.dayOfMonth,
        dateTime.hour,
        dateTime.minute,
        dateTime.second,
        dateTime.nanosecond / 1000
    ).format(formatter)

    public fun format(date: LocalDate): String = Date(
        date.year,
        date.monthNumber,
        date.dayOfMonth
    ).format(formatter)

    public fun parseInstant(string: String): Instant = formatter.parse(string).let {
        Instant.fromEpochMilliseconds(it.utc.unixMillisLong)
    }

    public fun parseDateTime(string: String): LocalDateTime = formatter.parseUtc(string).let {
        LocalDateTime(it.yearInt, it.month1, it.dayOfMonth, it.hours, it.minutes, it.seconds, it.milliseconds * 1000)
    }

    public fun parseDate(string: String): LocalDate = formatter.parseDate(string).let {
        LocalDate(it.year, it.month1, it.day)
    }

    public companion object {
        public operator fun invoke(pattern: String, optional: Boolean = false): DateFormat =
            DateFormat(com.soywiz.klock.DateFormat(pattern).let { if (optional) it.withOptional() else it })
    }
}

@JvmInline
public value class TimeFormat internal constructor(private val formatter: com.soywiz.klock.TimeFormat) {

    public fun format(time: LocalTime): String = Time(time.hour, time.minute, time.second).format(formatter)

    public fun parse(string: String): LocalTime = formatter.parseTime(string).let {
        LocalTime(it.hour, it.minute, it.second)
    }

    public companion object {
        public operator fun invoke(pattern: String, optional: Boolean = false): TimeFormat =
            TimeFormat(com.soywiz.klock.TimeFormat(pattern).let { if (optional) it.withOptional() else it })
    }
}