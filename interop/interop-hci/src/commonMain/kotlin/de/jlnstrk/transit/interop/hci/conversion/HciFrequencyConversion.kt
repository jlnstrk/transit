package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFreq
import de.jlnstrk.transit.common.model.Frequency
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import kotlin.time.Duration.Companion.minutes

internal fun HciJourneyFreq.asCommon(context: HciCommonContext): Frequency {
    return Frequency(
        minWaitTime = minC.minutes, // minC,
        maxWaitTime = maxC.minutes, // maxC,
       //  = numC
        until = null
    )
}