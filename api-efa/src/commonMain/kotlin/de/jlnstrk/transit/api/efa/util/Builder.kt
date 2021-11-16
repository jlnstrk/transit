package de.jlnstrk.transit.api.efa.util

import de.jlnstrk.transit.api.efa.endpoint.addinfo.EfaAddInfoRequest
import de.jlnstrk.transit.api.efa.endpoint.coord.EfaCoordRequest
import de.jlnstrk.transit.api.efa.endpoint.dm.EfaDmRequest
import de.jlnstrk.transit.api.efa.endpoint.stopfinder.EfaStopFinderRequest
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripRequest

public inline fun efaDmRequest(builder: EfaDmRequest.() -> Unit): EfaDmRequest =
    EfaDmRequest().also(builder)

public inline fun efaAddInfoRequest(builder: EfaAddInfoRequest.() -> Unit): EfaAddInfoRequest =
    EfaAddInfoRequest().also(builder)

public inline fun efaCoordRequest(builder: EfaCoordRequest.() -> Unit): EfaCoordRequest =
    EfaCoordRequest().also(builder)

public inline fun efaStopFinderRequest(builder: EfaStopFinderRequest.() -> Unit): EfaStopFinderRequest =
    EfaStopFinderRequest().also(builder)

public inline fun efaTripRequest(builder: EfaTripRequest.() -> Unit): EfaTripRequest =
    EfaTripRequest().also(builder)