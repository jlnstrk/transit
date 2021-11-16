package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.api.efa.model.EfaReference
import de.jlnstrk.transit.util.extensions.toProductSet
import de.jlnstrk.transit.util.model.Coordinates
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.denormalized
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaPoint.normalize(provider: EfaProvider): Location {
    val place = ref?.place
    val coordinates = ref?.coords?.let(EfaCoordinates::normalized)
    val literalId = stateless
    val numericId = ref?.id ?: stateless!!.hashCode().toLong()
    return when (this) {
        is EfaPoint.Stop -> Location.Station(
            name = obj,
            place, coordinates, literalId, numericId,
            products = modes?.let(provider::normalizeEfaMeans)?.toProductSet(),
            weight = quality
        )
        is EfaPoint.Poi -> Location.Poi(
            name = obj,
            place, coordinates, literalId, numericId
        )
        is EfaPoint.Place,
        is EfaPoint.PostCode -> Location.Place(
            name = name,
            place, coordinates, literalId, numericId
        )
        is EfaPoint.Street,
        is EfaPoint.SingleHouse,
        is EfaPoint.Crossing -> Location.Address(
            name = name,
            place, coordinates, literalId, numericId
        )
        else -> Location.Address(
            name = name,
            place, coordinates, literalId, numericId
        )
    }.also { provider.normalizeLocation(this, it) }
}

internal fun Location.denormalize(provider: EfaProvider): EfaPoint {
    val reference = EfaReference(
        id = numericId,
        omc = -1L,
        place = place,
        coords = coordinates?.let(Coordinates::denormalized),
        placeID = -1L
    )
    val name = name.orEmpty()
    val stateless = literalId
    val obj = ""
    return when (this) {
        is Location.Station -> EfaPoint.Stop(
            name, reference, stateless,
            sort = null,
            weight, obj,
            postTown = null,
            modes = products?.let(provider::denormalizeEfaMeans)
        )
        is Location.Address -> EfaPoint.SingleHouse(
            name, reference, stateless,
            sort = null,
            quality = null,
            obj,
            street = street!!,
            buildingNumber = buildingNumber!!
        )
        is Location.Place -> EfaPoint.Place(
            name, reference, stateless,
            sort = null, quality = null
        )
        is Location.Poi -> EfaPoint.Poi(
            name, reference, stateless,
            sort = null,
            quality = null,
            obj
        )
        else -> EfaPoint.Any(name, reference, stateless)
    }.also { provider.denormalizeLocation(this, it) }
}