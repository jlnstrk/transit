@file:UseSerializers(
    HapiLocalDateSerializer::class
)

package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.serializer.HapiLocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HapiXsd("1.29")
@Serializable
public data class HapiServiceDays(
    /** Start of the planning period of this data in format YYYY-MM-DD. */
    public val planningPeriodBegin: LocalDate?,
    /** End of the planning period of this data in format YYYY-MM-DD. */
    public val planningPeriodEnd: LocalDate?,
    /** Regular service days for this trip meaning the days where this train runs its regular schedule. */
    public val sDaysR: String?,
    /** Irregular service days for this trip meaning the days there this train runs on a different schedule. */
    public val sDaysI: String?,
    public val sDaysB: String?,
    /** First stop/station where this note is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxFrom: Int?,
    /** Last stop/station where this note is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxTo: Int?
)