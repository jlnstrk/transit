package de.jlnstrk.transit.client.hapi.request.delegate

import de.jlnstrk.transit.client.hapi.util.HAPI_LOCAL_TIME_FORMAT
import kotlinx.datetime.LocalTime

internal object HapiLocalTimeParam : HapiQueryParam<LocalTime>(
    serialize = HAPI_LOCAL_TIME_FORMAT::format,
    deserialize = HAPI_LOCAL_TIME_FORMAT::parse
)