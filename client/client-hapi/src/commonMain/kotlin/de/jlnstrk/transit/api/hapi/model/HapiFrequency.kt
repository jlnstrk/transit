@file:UseSerializers(
    HapiMinutesSerializer::class
)

package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.api.hapi.serializer.HapiMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** Alternatives for this leg by plan. */
@HapiXsd("1.29")
@Serializable
public data class HapiFrequency(
    /** List of alternative legs. */
    public val journey: List<HapiJourney> = emptyList(),
    /** Shortest wait time (in minutes). */
    public val waitMinimum: Duration?,
    /** Longest wait time (in minutes). */
    public val waitMaximum: Duration?,
    /** Count of alternative legs. */
    public val alternativeCount: Int?,
)