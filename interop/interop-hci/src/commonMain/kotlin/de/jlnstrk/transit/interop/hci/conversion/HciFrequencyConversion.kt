package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.HciFrequency
import de.jlnstrk.transit.common.model.Frequency
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciFrequency.asCommon(context: HciCommonContext): Frequency {
    return Frequency(
        minWaitTime = minC,
        maxWaitTime = maxC,
        numAlternatives = numC
    )
}