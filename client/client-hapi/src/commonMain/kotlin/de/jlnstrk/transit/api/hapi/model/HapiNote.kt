package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HafasRemarkCode
import de.jlnstrk.transit.api.hafas.HafasRemarkType
import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Contains a text with notes to be displayed for this leg, like attributes or footnotes. */
@HapiXsd("1.29")
@Serializable
public data class HapiNote(
    /** Note to be displayed */
    public val value: String,
    /** An identifier of this note.
     * The identifier is a two letter combination further identifying the content of the note. */
    public val key: HafasRemarkCode? = null,
    /** The type of this note. */
    public val type: HafasRemarkType?,
    /** The priority of this note. A lower priority value means a higher importance. */
    public val priority: Int = 100,
    /** First stop/station where this note is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxFrom: Int?,
    /** Last stop/station where this note is valid.
     * See the Stops list in the JourneyDetail response for this leg to get more details about this stop/station. */
    public val routeIdxTo: Int?,
    /** Normal version of this notes text */
    public val txtN: String?,
    /** Long version of this notes text */
    public val txtL: String?,
    /** Short version of this notes text */
    public val txtS: String?,
)