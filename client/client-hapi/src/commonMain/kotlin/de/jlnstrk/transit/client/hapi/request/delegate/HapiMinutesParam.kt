package de.jlnstrk.transit.client.hapi.request.delegate

import com.soywiz.klock.minutes
import de.jlnstrk.transit.util.Duration
import kotlin.math.roundToInt

internal object HapiMinutesParam : HapiQueryParam<Duration>(
    serialize = { it.minutes.roundToInt().toString() },
    deserialize = { it.toInt().minutes }
)