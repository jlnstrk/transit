package de.jlnstrk.transit.client.hapi.request.delegate

import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_TIME_FORMAT
import de.jlnstrk.transit.util.LocalTime

internal object HapiLocalTimeParam : HapiQueryParam<LocalTime>(
    serialize = HAPI_LOCAL_TIME_FORMAT::format,
    deserialize = HAPI_LOCAL_TIME_FORMAT::parseTime
)