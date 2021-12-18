package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.client.hci.model.gis.HciGis
import de.jlnstrk.transit.common.model.Gis
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext

internal fun HciGis.asCommon(context: HciCommonContext): Gis {
    return Gis(
        distance = dist,
        duration = durS,
        segments = segL.map {
            Gis.Segment(
                label = it.name,
                description = it.manTx,
                maneuver = null,
            )
        }
    )
}