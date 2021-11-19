package de.jlnstrk.transit.api.hapi.model.stop

import de.jlnstrk.transit.api.hafas.HapiXsd

/** Origin of a leg including location name, location type, location route index (if available),
 * departure time and date, realtime departure (if available), track and realtime track (if available) */
@HapiXsd("1.29")
public typealias HapiOrigin = HapiOriginDest