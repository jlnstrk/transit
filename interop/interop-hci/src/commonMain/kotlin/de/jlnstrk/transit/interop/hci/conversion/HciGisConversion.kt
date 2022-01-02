package de.jlnstrk.transit.interop.hci.conversion

import com.soywiz.klock.milliseconds
import de.jlnstrk.transit.client.hci.model.gis.HciGisRoute
import de.jlnstrk.transit.common.model.Gis
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciGisRoute.asCommon(context: HciCommonContext): Gis {
    return Gis(
        distance = dist!!,
        duration = kotlin.time.Duration.parse(durS!!).inWholeMilliseconds.milliseconds,
        segments = segL.map {
            Gis.Segment(
                label = it.name,
                description = it.manTx,
                maneuver = null,
            )
        }
    )
}