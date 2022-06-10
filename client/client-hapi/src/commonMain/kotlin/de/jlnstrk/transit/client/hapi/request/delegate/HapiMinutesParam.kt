package de.jlnstrk.transit.client.hapi.request.delegate

import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

internal object HapiMinutesParam : HapiQueryParam<Duration>(
    serialize = { it.inWholeMinutes.toString() },
    deserialize = { it.toInt().minutes }
)