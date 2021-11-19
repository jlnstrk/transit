package de.jlnstrk.transit.api.hci.model.journey

import kotlinx.serialization.Serializable

@Serializable
public enum class HciJourneyTrainPositionMode {
    // TODO: Effect?
    CALC,

    // TODO: Effect?
    CALC_FOR_REPORT,

    // TODO: Effect?
    CALC_FOR_REPORT_START,

    /** Return only calculated positions */
    CALC_ONLY,

    /** Return calculated and reported positions */
    CALC_REPORT,

    /** Return only reported positions */
    REPORT_ONLY,

    // TODO: Effect?
    REPORT_ONLY_WITH_STOPS
}