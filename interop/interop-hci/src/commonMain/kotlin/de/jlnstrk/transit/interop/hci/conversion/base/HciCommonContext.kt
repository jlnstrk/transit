package de.jlnstrk.transit.interop.hci.conversion.base

import de.jlnstrk.transit.client.hci.model.*
import de.jlnstrk.transit.client.hci.model.him.HciHimMessage
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.common.ReferenceTimezone
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon

internal class HciCommonContext(
    private val provider: HciProvider,
    common: HciCommon
) : HafasClassMapping by provider,
    ReferenceTimezone by provider {
    internal val locations = common.locL.lazyConversion(this, HciLocation::asCommon)
    internal val lines = common.prodL.lazyConversion(this, HciProduct::asCommon)
    internal val operators = common.opL.lazyConversion(this, HciOperator::asCommon)
    internal val polylines = common.polyL.lazyConversion(this, HciPolyline::asCommon)
    internal val messages = common.himL.lazyConversion(this, HciHimMessage::asCommon)
    internal val attributes = common.remL.lazyConversion(this, HciRemark::asCommon)
}