package de.jlnstrk.transit.api.efa

import de.jlnstrk.transit.api.efa.model.EfaCoordinateSystem

public data class EfaConfig(
    public var coordinateSystem: EfaCoordinateSystem = EfaCoordinateSystem.WGS84_DECIMAL,
    public var language: String? = null,
    public var iconCodeResolver: EfaIconCodeResolver? = null,
)