package de.jlnstrk.transit.client.hci.util

import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
public data class HciLocalTime(
    public val time: LocalTime,
    public val offsetDays: Int
)