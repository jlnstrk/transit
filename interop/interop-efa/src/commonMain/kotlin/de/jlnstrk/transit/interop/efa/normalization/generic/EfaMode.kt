package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.client.efa.model.EfaMode
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Means
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