package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hci.serializer.time.HciMinutesSerializer
import de.jlnstrk.transit.util.Duration
import kotlinx.serialization.Serializable

@Serializable
public data class HciReachPosition(
    public val locX: Int,
    @Serializable(with = HciMinutesSerializer::class)
    public val dur: Duration
)