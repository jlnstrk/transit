package de.jlnstrk.transit.util.model

public data class Coordinates(
    public var latitude: Double,
    public var longitude: Double,
    public var altitude: Double = Double.NaN
)