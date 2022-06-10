package de.jlnstrk.transit.common.extensions

import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.Via
import kotlin.time.Duration

public fun Via(
    location: Location,
    period: Duration? = null,
    vararg modes: Via.Mode
): Via = Via(
    location, period,
    modes.toSet().ifEmpty { null }
)