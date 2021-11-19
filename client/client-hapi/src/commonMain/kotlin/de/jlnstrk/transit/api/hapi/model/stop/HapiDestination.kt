package de.jlnstrk.transit.api.hapi.model.stop

import de.jlnstrk.transit.api.hafas.HapiXsd

/** Destination of a leg including location name, location type, location route index (if available),
 * arrival time and date, realtime arrival time (if available), track and realtime track (if available) */
@HapiXsd("1.29")
public typealias HapiDestination = HapiOriginDest