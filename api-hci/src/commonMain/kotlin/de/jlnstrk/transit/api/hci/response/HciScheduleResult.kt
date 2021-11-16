package de.jlnstrk.transit.api.hci.response

import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciUnixTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciScheduleResult : HciServiceResult() {
    @Serializable(with = HciLocalDateSerializer::class)
    public var fpB: LocalDate = LocalDate(0)
        private set

    @Serializable(with = HciLocalDateSerializer::class)
    public var fpE: LocalDate = LocalDate(0)
        private set

    @Serializable(with = HciUnixTimeSerializer::class)
    public var planrtTS: LocalDateTime = LocalDateTime(0)
        private set
}