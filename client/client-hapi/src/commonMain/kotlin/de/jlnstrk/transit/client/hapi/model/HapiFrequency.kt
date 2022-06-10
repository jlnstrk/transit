@file:UseSerializers(
    HapiMinutesSerializer::class
)

package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.journey.HapiJourney
import de.jlnstrk.transit.client.hapi.serializer.HapiMinutesSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlin.time.Duration

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