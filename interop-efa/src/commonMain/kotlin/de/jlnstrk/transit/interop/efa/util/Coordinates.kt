package de.jlnstrk.transit.interop.efa.util

import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.api.efa.model.EfaCoordinates
import de.jlnstrk.transit.util.model.Coordinates

internal inline fun EfaCoordinates.normalized(): Coordinates =
    Coordinates(latitude = y, longitude = x)

internal inline fun Coordinates.denormalized(): EfaCoordinates =
    EfaCoordinates(x = longitude, y = latitude, mapName = EfaCoordinateSystem.WGS84)
