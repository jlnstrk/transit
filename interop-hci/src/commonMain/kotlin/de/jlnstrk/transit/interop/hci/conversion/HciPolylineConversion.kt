package de.jlnstrk.transit.interop.hci.conversion

import de.jlnstrk.transit.api.hci.model.HciPolyline
import de.jlnstrk.transit.common.model.Coordinates
import de.jlnstrk.transit.common.model.Polyline
import de.jlnstrk.transit.interop.hci.conversion.base.HciCommonContext
import de.jlnstrk.transit.interop.hci.extensions.decodeGpa

internal fun HciPolyline.asCommon(context: HciCommonContext): Polyline {
    var commonPoints: List<Coordinates>? = null
    when {
        crd.isNotEmpty() -> {
            commonPoints = ArrayList(crd.size / dim)
            var i = 0
            while (i < crd.size) {
                val lat = crd[i++]
                val lon = crd[i++]
                var alt = Double.NaN
                if (dim == 3) {
                    alt = crd[i++]
                }
                commonPoints.add(Coordinates(lat, lon, alt))
            }
        }
        crdEncYX != null -> {
            commonPoints = crdEncYX!!.decodeGpa()
        }
    }
    val commonMarkers = ppLocRefL.map {
        Polyline.Marker(
            index = it.ppIdx,
            location = context.locations[it.locX]
        )
    }
    return Polyline(commonPoints.orEmpty(), commonMarkers)
}