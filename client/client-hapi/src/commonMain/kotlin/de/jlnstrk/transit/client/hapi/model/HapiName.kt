package de.jlnstrk.transit.client.hapi.model

import de.jlnstrk.transit.client.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Contains name of journey. */
@HapiXsd("1.29")
@Serializable
public data class HapiName(
    /** Name to be displayed. */
    public val name: String,
    /** The train number. */
    public val number: String,
    /** The train category. */
    public val category: String,
    /** Defines the first stop/station where this name is valid.
     * See the Stops list for details of the stop/station. */
    public val routeIdxFrom: Int = -1,
    /** Defines the last stop/station where this name is valid.
     * See the Stops list for details of the stop/station. */
    public val routeIdxTo: Int = -1,
    public val Product: HapiProduct?,
)