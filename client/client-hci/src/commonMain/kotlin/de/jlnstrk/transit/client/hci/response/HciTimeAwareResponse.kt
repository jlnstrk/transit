package de.jlnstrk.transit.client.hci.response

import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable

@Serializable
public abstract class HciTimeAwareResponse : HciScheduleResult() {
    @Serializable(with = HciLocalDateSerializer::class)
    public var sD: LocalDate = LocalDate(0)
        private set

    @Serializable(with = HciLocalTimeSerializer::class)
    public var sT: LocalTime = LocalTime(0)
        private set
}