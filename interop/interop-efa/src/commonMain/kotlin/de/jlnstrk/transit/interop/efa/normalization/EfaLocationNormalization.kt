package de.jlnstrk.transit.interop.efa.normalization

import de.jlnstrk.transit.api.efa.model.EfaPin
import de.jlnstrk.transit.api.efa.model.EfaPoint
import de.jlnstrk.transit.common.Normalization
import de.jlnstrk.transit.common.model.Location

public interface EfaLocationNormalization : de.jlnstrk.transit.common.Normalization {

    public fun normalizeLocation(source: EfaPoint, location: Location) {
        normalizeLocation(location)
    }

    public fun normalizeLocation(source: EfaPin, location: Location) {
        normalizeLocation(location)
    }

    public fun denormalizeLocation(normalized: Location, point: EfaPoint) {
    }
}