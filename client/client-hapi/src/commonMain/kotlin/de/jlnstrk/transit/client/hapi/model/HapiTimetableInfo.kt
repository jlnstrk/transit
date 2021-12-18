@file:UseSerializers(
    HapiLocalDateSerializer::class,
    HapiLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiTimetableInfo(
    public val date: LocalDate,
    public val time: LocalTime,
    public val ident: String,
    /** The attribute type specifies the type of the time table.
     * Valid values are ST (stop/station), ADR (address) or POI (point of interest).
     * If not specified, U (unknown) is returned. */
    public val type: Type = Type.U,
    /** Start date of the pool data timetable period. */
    public val begin: LocalDate,
    /** End date of the pool data timetable period. */
    public val end: LocalDate,
) {

    @Serializable
    public enum class Type {
        U,
        ST,
        ADR,
        POI
    }
}