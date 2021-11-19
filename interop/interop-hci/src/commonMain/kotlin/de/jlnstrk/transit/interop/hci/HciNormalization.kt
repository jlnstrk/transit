package de.jlnstrk.transit.interop.hci

import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.HciProduct
import de.jlnstrk.transit.api.hci.model.HciRemark
import de.jlnstrk.transit.api.hci.model.HciCommon
import de.jlnstrk.transit.common.Normalization
import de.jlnstrk.transit.common.model.Attribute
import de.jlnstrk.transit.common.model.Line
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.model.Message

public interface HciNormalization : Normalization {

    public fun normalizeLocation(
        common: HciCommon,
        original: HciLocation?,
        location: Location
    ) {
        normalizeLocation(location)
    }

    public fun normalizeLine(
        common: HciCommon,
        original: HciProduct?,
        line: Line
    ) {
        normalizeLine(line)
    }

    public fun normalizeMessage(
        common: HciCommon,
        original: HciMessage?,
        message: Message
    ) {
        normalizeMessage(message)
    }

    public fun normalizeAttribute(
        common: HciCommon,
        original: HciRemark?,
        attribute: Attribute
    ) {
        normalizeAttribute(attribute)
    }
}