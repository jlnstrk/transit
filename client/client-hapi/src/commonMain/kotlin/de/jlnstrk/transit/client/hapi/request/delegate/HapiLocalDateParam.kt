package de.jlnstrk.transit.client.hapi.request.delegate

import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_DATE_FORMAT
import kotlinx.datetime.LocalDate

internal object HapiLocalDateParam : HapiQueryParam<LocalDate>(
    serialize = HAPI_LOCAL_DATE_FORMAT::formatDate,
    deserialize = HAPI_LOCAL_DATE_FORMAT::parseDate
)