package de.jlnstrk.transit.interop.efa.util

import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.common.model.Location

internal fun Set<Location.Type>.denormalized(): Set<EfaPoint.ObjectType> {
    val result = mutableSetOf<EfaPoint.ObjectType>()
    if (contains(Location.Type.STATION)) {
        result.add(EfaPoint.ObjectType.STOP)
    }
    if (contains(Location.Type.ADDRESS)) {
        result.add(EfaPoint.ObjectType.STREET)
        result.add(EfaPoint.ObjectType.SINGLE_HOUSE)
        result.add(EfaPoint.ObjectType.CROSSING)
    }
    if (contains(Location.Type.POI)) {
        result.add(EfaPoint.ObjectType.POI)
    }
    if (contains(Location.Type.PLACE)) {
        result.add(EfaPoint.ObjectType.LOC)
    }
    return result
}