package de.jlnstrk.transit.api.efa.util

import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.api.efa.request.convert.serialize

public fun EfaCoordinates.formatQueryCoordinates(): String {
    return "$x:$y:${mapName.serialize()}"
}

public fun String.parseQueryCoordinates(): EfaCoordinates {
    val (x, y, system) = split(":")
    return EfaCoordinates(
        x.toDouble(), y.toDouble(),
        EfaCoordinateSystem.valueOf(system)
    )
}