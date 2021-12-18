package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.HciOperator
import de.jlnstrk.transit.common.model.Operator
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciOperator.asCommon(context: HciCommonContext): Operator {
    return Operator(
        id = id,
        name = name,
        website = url,
    )
}