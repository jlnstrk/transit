package de.jlnstrk.transit.client.hapi.util

import de.jlnstrk.transit.util.DateFormat
import de.jlnstrk.transit.util.TimeFormat

internal val HAPI_LOCAL_DATE_FORMAT: DateFormat = DateFormat("yyyy-MM-dd")
internal val HAPI_LOCAL_TIME_FORMAT: TimeFormat = TimeFormat("HH:mm[:ss]", optional = true)