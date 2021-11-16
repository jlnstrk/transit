package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.HciProduct
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.interop.hci.HciCommonContext
import de.jlnstrk.transit.interop.hci.HciProvider

internal fun HciProduct.toCommonLine(
    provider: HciProvider,
    context: HciCommonContext
): Line {
    return Line(
        label = prodCtx?.line ?: name,
        product = provider.singleFromClass(cls!!),
        id = pid,
        name = name,
        shortName = nameS,
        number = prodCtx?.num ?: number,
        operator = prodCtx?.admin
    )
}