package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.common.extensions.toLineSet
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciLocation.asCommon(context: HciCommonContext): Location {
    return when (type) {
        HciLocation.Type.STATION -> Location.Station(
            literalId = lid,
            numericId = extId ?: 0L,
            name = name,
            coordinates = crd?.asCommon(),
            products = pCls?.let(context::setFromBitmask)?.toProductSet(),
            lines = pRefL
                .map(context.lines::get)
                .toLineSet(),
            weight = wt,
            isSubStation = isMainMast == false || mMastLocX != null
        )
        HciLocation.Type.ADDRESS -> Location.Address(
            literalId = lid,
            numericId = lid.hashCode().toLong(),
            name = name,
            coordinates = crd?.asCommon()
        )
        HciLocation.Type.POI -> Location.Poi(
            literalId = lid,
            numericId = lid.hashCode().toLong(),
            name = name,
            coordinates = crd?.asCommon()
        )
        else -> throw IllegalStateException()
    }
}

internal fun Location.asHci(): HciLocation {
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