package de.jlnstrk.transit.interop.hci.conversion

import com.soywiz.klock.minutes
import de.jlnstrk.transit.client.hci.model.journey.HciJourneyFreq
import de.jlnstrk.transit.common.model.Frequency
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import de.jlnstrk.transit.util.Duration

internal fun HciJourneyFreq.asCommon(context: HciCommonContext): Frequency {
    return Frequency(
        minWaitTime = minC.minutes, // minC,
        maxWaitTime = maxC.minutes, // maxC,
       //  = numC
        until = null
    )
}