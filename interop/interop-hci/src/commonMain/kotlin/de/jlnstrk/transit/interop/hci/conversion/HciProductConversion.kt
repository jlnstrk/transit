package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.HciProduct
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciProduct.asCommon(context: HciCommonContext): Line {
    return Line(
        product = cls.let(context::singleFromClass),
        label = prodCtx?.line ?: name,
        id = prodCtx?.lineId ?: pid,
        name = name,
        shortName = nameS,
        number = prodCtx?.num ?: number,
        operator = oprX?.let(context.operators::get)?.name,
        admin = prodCtx?.admin
    )
}