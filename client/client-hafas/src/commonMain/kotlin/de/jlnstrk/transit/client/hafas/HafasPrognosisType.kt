package de.jlnstrk.transit.client.hafas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HafasPrognosisType {
    /** The realtime data was calculated by the server */
    CALCULATED,

    /** The journey is cancelled */
    CANCELLED,

    // TODO: What does this mean exactly?
    CORRECTED,

    /** The journey departure is affected by a vehicle issue */
    @SerialName("PARTIAL_FAILURE_AT_DEP")
    PARTIAL_FAILURE_AT_DEPARTURE,

    /** The journey arrival is affected by a vehicle issue */
    @SerialName("PARTIAL_FAILURE_AT_ARR")
    PARTIAL_FAILURE_AT_ARRIVAL,

    /** The realtime data is based on a prognosis by the server */
    PROGNOSED,

    /** The realtime data is based on a reported vehicle position */
    REPORTED,

    /** The realtime data is based on the schedule */
    SCHEDULED,

    /** The realtime data has been updated manually */
    MANUAL,
}