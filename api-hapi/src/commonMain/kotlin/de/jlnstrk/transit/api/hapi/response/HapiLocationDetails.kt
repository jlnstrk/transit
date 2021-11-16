package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.location.HapiCoordLocation
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** The location contains details for a stop/station or POI. */
@HapiXsd("1.29")
@Serializable
public data class HapiLocationDetails(
    public val stopLocationOrCoordLocation: HapiCoordLocation
) : HapiResponse()