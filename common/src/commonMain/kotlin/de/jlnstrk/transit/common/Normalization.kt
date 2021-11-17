package de.jlnstrk.transit.common

import de.jlnstrk.transit.util.model.Attribute
import de.jlnstrk.transit.util.model.Line
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.model.Message

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