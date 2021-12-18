package de.jlnstrk.transit.client.hapi.response

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.location.HapiCoordLocation
import de.jlnstrk.transit.client.hapi.response.base.HapiResponse
import kotlinx.serialization.Serializable

/** The location contains details for a stop/station or POI. */
@HapiXsd("1.29")
@Serializable
public data class HapiLocationDetails(
    public val stopLocationOrCoordLocation: HapiCoordLocation
) : HapiResponse()