package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.HciRemark
import de.jlnstrk.transit.common.model.Attribute
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciRemark.asCommon(context: HciCommonContext): Attribute {
    return Attribute(
        name = txtS ?: txtN.orEmpty()
    )
}