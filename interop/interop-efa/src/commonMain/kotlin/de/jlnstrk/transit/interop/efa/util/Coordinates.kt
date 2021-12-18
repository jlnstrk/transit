package de.jlnstrk.transit.interop.efa.util

import de.jlnstrk.transit.client.efa.model.EfaCoordinateSystem
import de.jlnstrk.transit.client.efa.model.EfaCoordinates
import de.jlnstrk.transit.common.model.Coordinates

internal fun EfaCoordinates.normalized(): Coordinates =
    Coordinates(latitude = y, longitude = x)

internal fun Coordinates.denormalized(): EfaCoordinates =
    EfaCoordinates(x = longitude, y = latitude, mapName = EfaCoordinateSystem.WGS84)
