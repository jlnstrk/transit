package de.jlnstrk.transit.util

import com.soywiz.klock.*
import com.soywiz.klock.DateFormat
import com.soywiz.klock.TimeFormat

public typealias LocalTime = Time
public typealias LocalDate = Date
public typealias LocalDateTime = DateTime
public typealias OffsetDateTime = DateTimeTz

public typealias DateFormatter = DateFormat
public typealias TimeFormatter = TimeFormat

public typealias Duration = TimeSpan

public typealias ZoneOffset = TimezoneOffset

public infix fun OffsetDateTime.until(other: DateTimeTz): Duration = other.minus(this)