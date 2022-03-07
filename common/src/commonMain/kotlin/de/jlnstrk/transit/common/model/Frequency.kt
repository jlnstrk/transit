package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.Duration
import de.jlnstrk.transit.util.OffsetDateTime

public data class Frequency(
    public val minWaitTime: Duration?,
    public val maxWaitTime: Duration?,
    public val until: OffsetDateTime?
)