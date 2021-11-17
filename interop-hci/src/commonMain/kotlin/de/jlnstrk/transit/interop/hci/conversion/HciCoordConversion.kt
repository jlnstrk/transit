package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import de.jlnstrk.transit.common.model.Coordinates

public fun HciCoord.asCommon(): Coordinates {
    return Coordinates(
        latitude = y.toDouble() / 1E6,
        longitude = x.toDouble() / 1E6
    )
}

public fun Coordinates.asHci(): HciCoord {
    return HciCoord(
        x = (longitude * 1E6).toLong(),
        y = (latitude * 1E6).toLong()
    )
}