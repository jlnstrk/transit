package de.jlnstrk.transit.api.hapi.util

import com.soywiz.klock.DateFormat
import com.soywiz.klock.TimeFormat

internal val HAPI_LOCAL_DATE_FORMAT: DateFormat = DateFormat("yyyy-MM-dd")
internal val HAPI_LOCAL_TIME_FORMAT: TimeFormat = TimeFormat("HH:mm[:ss]").withOptional()