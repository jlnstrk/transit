package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.Duration

public data class Via(
    public val location: Location,
    public val modes: Set<Mode>? = null,
    public val period: Duration? = null,
) {

    public enum class Mode {
        REQUIRES_ALIGHTING,
        REQUIRES_BOARDING
    }

}