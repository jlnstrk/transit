package de.jlnstrk.transit.api.hapi.request.delegate

import com.soywiz.klock.format
import com.soywiz.klock.parseDate
import de.jlnstrk.transit.api.hapi.util.HAPI_LOCAL_DATE_FORMAT
import de.jlnstrk.transit.util.LocalDate

internal object HapiLocalDateParam : HapiQueryParam<LocalDate>(
    serialize = HAPI_LOCAL_DATE_FORMAT::format,
    deserialize = HAPI_LOCAL_DATE_FORMAT::parseDate
)