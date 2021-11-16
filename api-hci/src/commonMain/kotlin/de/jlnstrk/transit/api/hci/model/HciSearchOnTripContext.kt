package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable

@Serializable
public data class HciSearchOnTripContext(
    @Serializable(with = HciLocalDateSerializer::class)
    public val calcDate: LocalDate,

    @Serializable(with = HciLocalTimeSerializer::class)
    public val calcTime: LocalTime,

    public val locMode: LocationMode,

    public val reqMode: RequestMode,

    public val jid: String?,

    // TODO: Name?
    public val cnLocX: Int?,

    // TODO: Name?
    public val pLocX: Int?,

    public val sectX: Int?
) {

    @Serializable
    public enum class LocationMode {
        UNKNOWN,
        FROM_START
    }

    @Serializable
    public enum class RequestMode {
        STOP_TO_STOP
    }

}