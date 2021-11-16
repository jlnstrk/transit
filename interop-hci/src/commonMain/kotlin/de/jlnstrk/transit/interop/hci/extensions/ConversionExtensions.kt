package de.jlnstrk.transit.interop.hci.extensions

import de.jlnstrk.transit.api.hci.model.geo.HciCoord
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.util.model.Coordinates
import de.jlnstrk.transit.util.model.Location

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

public fun Location.asHci(): HciLocation {
    return when (this) {
        is Location.Station -> HciLocation(
            type = HciLocation.Type.STATION,
            name = name.orEmpty(),
            lid = literalId!!,
            extId = numericId,
            crd = coordinates?.asHci()
        )
        is Location.Address,
        is Location.Place -> HciLocation(
            type = HciLocation.Type.ADDRESS,
            name = name.orEmpty(),
            lid = literalId!!,
            crd = coordinates?.asHci()
        )
        is Location.Poi -> HciLocation(
            type = HciLocation.Type.POI,
            name = name.orEmpty(),
            lid = literalId!!,
            crd = coordinates?.asHci()
        )
        is Location.Point -> HciLocation(
            type = HciLocation.Type.ADDRESS,
            name = name,
            crd = coordinates?.asHci(),
        )
        else -> throw IllegalStateException()
    }
}