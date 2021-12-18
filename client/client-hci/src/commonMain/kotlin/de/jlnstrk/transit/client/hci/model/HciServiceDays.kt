package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hci.serializer.HciServiceDaysBitmaskSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
public data class HciServiceDays(
    /** Returns a textual description of the day pattern with regular service */
    public val sDaysR: String?,

    /** Returns a textual description of the day pattern with irregular service */
    public val sDaysI: String?,

    /** Returns a bitmask => list of dates with service */
    @Serializable(with = HciServiceDaysBitmaskSerializer::class)
    public val sDaysB: List<@Contextual LocalDate> = emptyList(),

    public val fLocX: Int?,

    public val fLocIdx: Int?,

    public val tLocX: Int?,

    public val tLocIdx: Int?,
)