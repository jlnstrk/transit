package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.Duration

public data class Gis(
    public val distance: Int,
    public val duration: Duration,
    public val segments: List<Segment>,
) {

    public data class Segment(
        public val label: String?,
        public val description: String?,
        public val maneuver: Maneuver?,
    )

    public enum class Maneuver {

    }
}