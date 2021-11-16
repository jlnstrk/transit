package de.jlnstrk.transit.interop.efa.normalization.generic

import de.jlnstrk.transit.api.efa.model.EfaLine
import de.jlnstrk.transit.api.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.api.efa.model.EfaOperator
import de.jlnstrk.transit.api.efa.model.EfaServingLine
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.interop.efa.EfaProvider

internal fun EfaLine.normalize(provider: EfaProvider): Line {
    return Line(
        product = provider.normalizeEfaMeans(motType ?: EfaMeansOfTransport.OTHER),
        label = name ?: number ?: "<?>",
        name = name,
        number = number,
        id = productId.toString(),
        shortName = name,
        operator = itdOperator?.name,
        admin = null
    )
}

internal fun EfaServingLine.normalize(provider: EfaProvider, operator: EfaOperator?): Line {
    return Line(
        product = provider.normalizeEfaMeans(motType),
        label = number ?: name,
        name = name,
        shortName = name,
        number = number,
        operator = operator?.name
    )
}