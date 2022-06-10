package de.jlnstrk.transit.client.hapi.request.delegate

import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_DATE_FORMAT
import kotlinx.datetime.LocalDate

internal object HapiLocalDateParam : HapiQueryParam<LocalDate>(
    serialize = HAPI_LOCAL_DATE_FORMAT::format,
    deserialize = HAPI_LOCAL_DATE_FORMAT::parseDate
)