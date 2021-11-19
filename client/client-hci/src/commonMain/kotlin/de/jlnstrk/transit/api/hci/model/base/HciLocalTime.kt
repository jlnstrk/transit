package de.jlnstrk.transit.api.hci.model.base

import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable

@Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
public data class HciLocalTime(
    public val time: LocalTime,
    public val offsetDays: Int
)