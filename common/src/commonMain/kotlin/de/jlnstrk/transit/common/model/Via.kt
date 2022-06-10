package de.jlnstrk.transit.common.model

import kotlin.time.Duration


public data class Via(
    public val location: Location,
    public val period: Duration? = null,
    public val modes: Set<Mode>? = null,
) {

    public enum class Mode {
        ALIGHTING,
        BOARDING,
    }
}