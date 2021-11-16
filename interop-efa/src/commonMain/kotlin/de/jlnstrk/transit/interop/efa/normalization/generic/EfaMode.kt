package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaMode
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Means
import de.jlnstrk.transit.interop.efa.EfaProvider

internal fun EfaMode.normalize(provider: EfaProvider): Line {
    return Line(
        product = code?.let(provider::normalizeEfaMeans) ?: Means.OTHER,
        label = number.orEmpty(),
        number = number,
        id = diva.stateless,
        name = name,
        shortName = number,
        operator = diva.operator
    )
}