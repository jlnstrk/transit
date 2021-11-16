package de.jlnstrk.transit.interop.efa.normalization

import de.jlnstrk.transit.api.efa.model.EfaPin
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.util.Normalization
import de.jlnstrk.transit.util.model.Location

public interface EfaLocationNormalization : Normalization {

    public fun normalizeLocation(source: EfaPoint, location: Location) {
        normalizeLocation(location)
    }

    public fun normalizeLocation(source: EfaPin, location: Location) {
        normalizeLocation(location)
    }

    public fun denormalizeLocation(normalized: Location, point: EfaPoint) {
    }
}