package de.jlnstrk.transit.api.hapi.model.journey

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.*
import de.jlnstrk.transit.api.hapi.model.stop.HapiStop
import de.jlnstrk.transit.api.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.api.hapi.serializer.HapiReferenceUnwrapSerializer
import kotlinx.serialization.Serializable

/** The element Journey contains all information about a journey like name, direction, lon, lat,
 * train number and train category. It also contains a reference to journey details. */
@HapiXsd("1.29")
@Serializable
public data class HapiJourney(
    /** Specifies the name of the journey (e.g. "Bus 100") as used for display. */
    public val name: String,
    /** Direction information. This is the last stop of the journey.
     * Get the full journey of the train or bus with the JourneyDetails service. */
    public val direction: String,
    /** The current longitude position of the journey. */
    public val lon: Double?,
    /** The current latitude position of the journey. */
    public val lat: Double?,
    /** Train number as used for display. */
    public val trainNumber: String?,
    /** Train category as used for display. */
    public val trainCategory: String?,

    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Stops: List<HapiStop> = emptyList(),
    @Serializable(with = HapiReferenceUnwrapSerializer::class)
    public val JourneyDetailRef: String?,
    public val Product: HapiProduct?,
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Notes: List<HapiNote> = emptyList(),
    public val Messages: List<HapiMessage> = emptyList(),
    public val Occupancy: List<HapiOccupancy> = emptyList(),
)