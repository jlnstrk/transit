package de.jlnstrk.transit.common

import de.jlnstrk.transit.common.model.Attribute
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.Message

public interface Normalization {

    public fun normalizeLocation(location: Location) {
    }

    public fun normalizeLine(line: Line) {
    }

    public fun normalizeMessage(message: Message) {
    }

    public fun normalizeAttribute(attribute: Attribute) {
    }
}