package de.jlnstrk.transit.api.hapi.response

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.location.HapiStopOrCoordLocation
import de.jlnstrk.transit.api.hapi.response.base.HapiResponse
import de.jlnstrk.transit.api.hapi.serializer.HapiStopOrCoordLocationSerializer
import kotlinx.serialization.Serializable

/** The location list contains either named coordinates or stops/stations with name and id
 * as a result of a location request. The data of every list entry can be used
 * for further trip or departureBoard requests. */
@HapiXsd("1.29")
@Serializable
public class HapiLocationList(
    public val stopLocationOrCoordLocation: List<@Serializable(with = HapiStopOrCoordLocationSerializer::class) HapiStopOrCoordLocation>
) : HapiResponse()