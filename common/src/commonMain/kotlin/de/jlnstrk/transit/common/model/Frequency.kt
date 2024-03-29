package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.Duration

public data class Frequency(
    public val minWaitTime: Duration?,
    public val maxWaitTime: Duration?,
    public val numAlternatives: Int?
)