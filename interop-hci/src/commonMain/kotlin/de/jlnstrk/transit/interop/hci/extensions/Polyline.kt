@file:Suppress("DuplicatedCode")

package de.jlnstrk.transit.interop.hci.extensions

import de.jlnstrk.transit.common.model.Coordinates

public fun String.decodeGpa(): List<Coordinates> {
    val path = ArrayList<Coordinates>(length / 2)
    var lat = 0
    var lon = 0
    var index = 0
    while (index < length) {
        var latResult = 1
        var latShift = 0
        var latB: Int
        do {
            latB = this[index++].code - 63 - 1
            latResult += latB shl latShift
            latShift += 5
        } while (latB >= 0x1f)
        lat += if (latResult and 1 != 0) (latResult shr 1).inv() else latResult shr 1
        var lonResult = 1
        var lonShift = 0
        var lonB: Int
        do {
            lonB = this[index++].code - 63 - 1
            lonResult += lonB shl lonShift
            lonShift += 5
        } while (lonB >= 0x1f)
        lon += if (lonResult and 1 != 0) (lonResult shr 1).inv() else lonResult shr 1
        path.add(Coordinates(lat.toDouble() / 1E5, lon.toDouble() / 1E5))
    }
    return path
}