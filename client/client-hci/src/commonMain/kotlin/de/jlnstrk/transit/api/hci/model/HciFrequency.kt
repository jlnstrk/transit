@file:UseSerializers(
    HciMinutesSerializer::class
)

package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class HciFrequency(
    public val minC: Duration?,

    public val maxC: Duration?,

    public val numC: Int?,

    public val jnyL: List<HciJourney>?
)