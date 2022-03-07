package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.client.efa.model.EfaPoint
import de.jlnstrk.transit.client.efa.model.EfaReference
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Coordinates
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.denormalized
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaPoint.normalize(provider: EfaProvider): Location {
    val place = ref?.place
    val coordinates = ref?.coords?.let(EfaCoordinates::normalized)
    val id = ref?.id?.toString() ?: stateless
    return when (this) {
        is EfaPoint.Stop -> Location.Station(
            name = obj.orEmpty(),
            place = place,
            coordinates = coordinates ?: Coordinates(Double.NaN, Double.NaN),
            id = id.orEmpty(),
            products = modes?.let(provider::normalizeEfaMeans)?.toProductSet(),
            weight = quality
        )
        is EfaPoint.Poi -> Location.Poi(
            name = obj.orEmpty(),
            place = place,
            coordinates = coordinates ?: Coordinates(Double.NaN, Double.NaN),
            id = id.orEmpty(),
        )
        is EfaPoint.Place,
        is EfaPoint.PostCode -> Location.Place(
            name = name.orEmpty(),
            place = place,
            coordinates = coordinates ?: Coordinates(Double.NaN, Double.NaN),
            id = id.orEmpty(),
        )
        is EfaPoint.Street,
        is EfaPoint.SingleHouse,
        is EfaPoint.Crossing -> Location.Address(
            name = name.orEmpty(),
            place = place,
            coordinates = coordinates ?: Coordinates(Double.NaN, Double.NaN),
            id = id.orEmpty(),
        )
        else -> Location.Address(
            name = name.orEmpty(),
            place = place,
            coordinates = coordinates ?: Coordinates(Double.NaN, Double.NaN),
            id = id.orEmpty(),
        )
    }.also { provider.normalizeLocation(this, it) }
}

internal fun Location.denormalize(provider: EfaProvider): EfaPoint {
    val reference = EfaReference(
        id = id?.toLong(),
        place = place,
        coords = coordinates?.let(Coordinates::denormalized),
    )
    return when (this) {
        is Location.Station -> EfaPoint.Stop(
            name, reference, id,
            quality = weight,
            modes = products?.let(provider::denormalizeEfaMeans)
        )
        is Location.Address -> EfaPoint.SingleHouse(
            name, reference, id,
            street = street!!,
            buildingNumber = buildingNumber!!
        )
        is Location.Place -> EfaPoint.Place(name, reference, id)
        is Location.Poi -> EfaPoint.Poi(name, reference, id)
        else -> EfaPoint.Any(name, reference, id)
    }.also { provider.denormalizeLocation(this, it) }
}