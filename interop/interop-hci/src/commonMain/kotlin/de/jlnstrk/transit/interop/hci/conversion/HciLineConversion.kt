package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.HciLine
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciLine.asCommon(context: HciCommonContext): Line {
    throw NotImplementedError()
}