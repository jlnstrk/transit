@file:UseSerializers(
    HapiLocalDateSerializer::class
)

package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiTimetableInfo
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** The timetable info list contains entries for each pool of the connected HAFAS server.
 * Each entry has a date and time attribute representing the point in time the pool was generated.
 * The attribute ident identifies that specific pool.
 * The list itself carries the begin and end date of the planning period as attributes. */
@HapiXsd("1.29")
@Serializable
public data class HapiTimetableInfoList(
    public val TimetableInfo: List<HapiTimetableInfo> = emptyList(),
    public val begin: LocalDate,
    public val end: LocalDate,
) : HapiResponse()