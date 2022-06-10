package de.jlnstrk.transit.common.model

import kotlinx.datetime.Instant
import kotlin.time.Duration


public data class Frequency(
    public val minWaitTime: Duration?,
    public val maxWaitTime: Duration?,
    public val until: Instant?
)