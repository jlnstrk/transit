package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.client.efa.model.EfaPin
import de.jlnstrk.transit.common.extensions.toProductSet
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaPin.normalize(provider: EfaProvider): Location {
    val name = desc
    val place = locality
    val coordinates = coords.normalized()
    return when (type) {
        EfaPin.Type.STOP -> {
            val majorMeans = attrs
                .filterIsInstance<EfaPin.Attribute.StopMajorMeans>()
                .firstOrNull()
                ?.majorMeans
                ?.let { setOf(it) }
            val meansList = attrs
                .filterIsInstance<EfaPin.Attribute.StopMeansList>()
                .firstOrNull()
                ?.means
            val globalId = attrs
                .filterIsInstance<EfaPin.Attribute.StopGlobalId>()
                .firstOrNull()
                ?.globalId
            Location.Station(
                name = name,
                place = place,
                coordinates = coordinates,
                id = stateless.toString(),
                products = (meansList ?: majorMeans)
                    ?.let(provider::normalizeEfaMeans)
                    ?.toProductSet()
            )
        }
        EfaPin.Type.STREET -> Location.Address(
            name = name,
            place = place,
            coordinates = coordinates,
            id = stateless.toString()
        )
        EfaPin.Type.POI_POINT -> Location.Poi(
            name = name,
            place = place,
            coordinates = coordinates,
            id = stateless.toString()
        )
        else -> throw UnsupportedOperationException()
    }.also { provider.normalizeLocation(this, it) }
}