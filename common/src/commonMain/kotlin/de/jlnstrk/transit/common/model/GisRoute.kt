package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.util.Duration

public data class GisRoute(
    /** The total distance of this route in meters */
    public val distance: Int,
    /** The duration it takes to complete this route */
    public val duration: Duration,
    /** The individual segments of this route */
    public val segments: List<Segment>,
) {

    public data class Segment(
        /** The textual summary of this segment */
        public val summary: String?,
        /** The textual description of this segment */
        public val description: String?,
        /** The maneuver encoded by this segment */
        public val maneuver: Maneuver,
        /** The user orientation after this segment */
        public val orientation: Orientation?,
    )

    public enum class Maneuver {
        FROM,
        TO,
        ON,
        LEFT,
        RIGHT,
        KEEP_LEFT,
        KEEP_RIGHT,
        HALF_LEFT,
        HALF_RIGHT,
        KEEP_HALF_LEFT,
        KEEP_HALF_RIGHT,
        SHARP_LEFT,
        SHARP_RIGHT,
        KEEP_SHARP_LEFT,
        KEEP_SHARP_RIGHT,
        STRAIGHT,
        U_TURN,
        ENTER,
        LEAVE,
        ENTER_ROUNDABOUT,
        STAY_IN_ROUNDABOUT,
        LEAVE_ROUNDABOUT,
        ENTER_FERRY,
        LEAVE_FERRY,
        CHANGE_HIGHWAY,
        CHECK_IN_FERRY,
        CHECK_OUT_FERRY,
        ELEVATOR,
        ELEVATOR_DOWN,
        ELEVATOR_UP,
        ESCALATOR,
        ESCALATOR_DOWN,
        ESCALATOR_UP,
        STAIRS,
        STAIRS_DOWN,
        STAIRS_UP,
    }

    public enum class Orientation {
        NORTH,
        NORTH_EAST,
        EAST,
        SOUTH_EAST,
        SOUTH,
        SOUTH_WEST,
        WEST,
        NORTH_WEST,
    }
}