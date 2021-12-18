package de.jlnstrk.transit.client.efa.util

import de.jlnstrk.transit.client.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.client.efa.request.convert.serialize

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