package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.location.HciLocationType
import de.jlnstrk.transit.common.extensions.toLineSet
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Coordinates
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciLocation.asCommon(context: HciCommonContext): Location {
    return when (type) {
        HciLocationType.S -> Location.Station(
            id = lid!!,
            name = name.orEmpty(),
            coordinates = crd?.asCommon() ?: Coordinates(0.0, 0.0),
            products = pCls.let(context::setFromBitmask).toProductSet(),
            lines = pRefL
                .map(context.lines::get)
                .toLineSet(),
            weight = wt,
            isSubStation = !isMainMast || mMastLocX != null
        )
        HciLocationType.A -> Location.Address(
            id = lid!!,
            name = name.orEmpty(),
            coordinates = crd?.asCommon() ?: Coordinates(0.0, 0.0)
        )
        HciLocationType.P -> Location.Poi(
            id = lid!!,
            name = name.orEmpty(),
            coordinates = crd?.asCommon() ?: Coordinates(0.0, 0.0)
        )
        else -> throw IllegalStateException()
    }
}

internal fun Location.asHci(): HciLocation {
    return when (this) {
        is Location.Station -> HciLocation(
            type = HciLocationType.S,
            name = name.orEmpty(),
            lid = id,
            extId = id,
            crd = coordinates.asHci()
        )
        is Location.Address,
        is Location.Place -> HciLocation(
            type = HciLocationType.A,
            name = name.orEmpty(),
            lid = id!!,
            crd = coordinates?.asHci()
        )
        is Location.Poi -> HciLocation(
            type = HciLocationType.P,
            name = name,
            lid = id,
            crd = coordinates.asHci()
        )
        is Location.Point -> HciLocation(
            type = HciLocationType.A,
            name = name,
            crd = coordinates.asHci(),
        )
        else -> throw IllegalStateException()
    }
}