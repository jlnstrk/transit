package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaPin
import de.jlnstrk.transit.util.extensions.toProductSet
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.util.normalized

internal fun EfaPin.normalize(provider: EfaProvider): Location {
    val name = desc
    val place = locality
    val coordinates = coords.normalized()
    val literalId = stateless.toString()
    val numericId = stateless
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
                name, place, coordinates, literalId, numericId,
                products = (meansList ?: majorMeans)
                    ?.let(provider::normalizeEfaMeans)
                    ?.toProductSet()
            )
        }
        EfaPin.Type.STREET -> Location.Address(name, place, coordinates, literalId, numericId)
        EfaPin.Type.POI_POINT -> Location.Poi(name, place, coordinates, literalId, numericId)
        else -> throw UnsupportedOperationException()
    }.also { provider.normalizeLocation(this, it) }
}