package de.jlnstrk.transit.common.normalize

import de.jlnstrk.transit.common.model.Attribute
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Message

public interface Normalization : LocationNormalization {

    public fun normalizeLine(line: Line): Line = line

    public fun normalizeMessage(message: Message): Message = message

    public fun normalizeAttribute(attribute: Attribute): Attribute = attribute
}